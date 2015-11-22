import os
import sys
import requests
import time
import logging
import subprocess

LOOP_SLEEP = 10

_logger = logging.getLogger("Start_Service")

def get_app_list(apps):

    app_list = []

    if isinstance(apps, list):
        for app in apps:
            app_list.append(app["name"])
    else:
        app_list.append(apps["name"])

    return app_list

if __name__ == "__main__":

    logging.basicConfig(level=logging.INFO)
    dependencies_env_value = os.environ["SCD_DEPENDENCIES"]

    if dependencies_env_value == "":
        dependencies = []
    else:
        dependencies = dependencies_env_value.split(",")

    _logger.info("Dependencies: %s" % dependencies)
    eureka_host = os.environ["SCD_EUREKA_HOST"]
    _logger.info("Eureka Host: %s" % eureka_host)
    eureka_port = os.environ["SCD_EUREKA_PORT"]
    _logger.info("Eureka Port: %s" % eureka_port)

    eureka_up = False

    # First we wait to see if eureka is up
    while not eureka_up:
        health_response = requests.get("http://%s:%s/health" % (eureka_host, eureka_port))

        if health_response.status_code != 200:
            _logger.info("Non 200 returned sleeping for %s seconds and will try again" % LOOP_SLEEP)
            time.sleep(LOOP_SLEEP)
            continue

        health_json = health_response.json()

        health_status = health_json["status"]
        _logger.info("Health Status: %s" % health_status)

        if health_status.lower() != "up":
            _logger.info("Health status not 'UP' sleeping for %s seconds and willl try again" % LOOP_SLEEP)
            time.sleep(LOOP_SLEEP)
            continue
        else:
            eureka_up = True

    # Now we look to see if the dependencies are listed in EUREKA
    if len(dependencies) > 0:
        app_found = False

        while not app_found:
            app_info_response = requests.get("http://%s:%s/eureka/apps" % (eureka_host, eureka_port))
            app_info = app_info_response.json()

            _logger.info("App Info: %s" % app_info)
            apps = app_info["applications"]["application"]

            if apps == None:
                _logger.info("No applications listed sleeping for $s seconds and will try again" * LOOP_SLEEP)
                time.sleep(LOOP_SLEEP)
                continue
            else:
                app_list = get_app_list(apps)

                for app_name in app_list:
                    for dep_name in dependencies:
                        if dep_name.lower() == app_name.lower():
                            _logger.info("Found dependency %s in app_list" % dep_name)
                            dependencies.remove(dep_name)
                            break
                    if len(dependencies) == 0:
                        _logger.info("No dependencies left, breaking")
                        break

                if len(dependencies) == 0:
                    _logger.info("No dependencies left, setting app_found to True")
                    app_found = True
    else:
        _logger.info("No dependencies detected")
    process = subprocess.Popen(["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"])

    while process.returncode is None:
        _logger.info("Process pid: %s" % process.p)