# 로컬의 `.env` 파일이 도커 내부 환경변수 오염할 수 없도록 제한
DC := docker compose --env-file /dev/null

##@ General

# The help target prints out all targets with their descriptions organized
# beneath their categories. The categories are represented by '##@' and the
# target descriptions by '##'. The awk commands is responsible for reading the
# entire set of makefiles included in this invocation, looking for lines of the
# file as xyz: ## something, and then pretty-format the target and help. Then,
# if there's a line with ##@ something, that gets pretty-printed as a category.
# More info on the usage of ANSI control characters for terminal formatting:
# https://en.wikipedia.org/wiki/ANSI_escape_code#SGR_parameters
# More info on the awk command:
# http://linuxcommand.org/lc3_adv_awk.php

help: ## Display this help.
	@awk 'BEGIN {FS = ":.*##"; printf "\nUsage:\n  make \033[36m<target>\033[0m\n"} /^[a-zA-Z_0-9-]+:.*?##/ { printf "  \033[36m%-15s\033[0m %s\n", $$1, $$2 } /^##@/ { printf "\n\033[1m%s\033[0m\n", substr($$0, 5) } ' $(MAKEFILE_LIST)

ci-base:
	$(DC) -f docker-compose.yml -f docker-compose.ci.yml run --rm app ${CMD}

port-base:
	$(DC) -f docker-compose.yml -f docker-compose.port.yml run --service-ports --rm app ${CMD}

port-base-rebuild:
	./gradlew build && $(DC) build --no-cache --force-rm && $(DC) -f docker-compose.yml -f docker-compose.port.yml run --service-ports --rm app ${CMD}

stand-alone: ## Run service on local with port.
stand-alone: CMD=sh -c 'java -jar app.jar'
stand-alone: port-base

stand-alone-rebuild: ## Run service on local with port.
stand-alone-rebuild: CMD=sh -c 'java -jar app.jar'
stand-alone-rebuild: port-base-rebuild
