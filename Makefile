FRONTEND_FOLDER = src/main/resources/frontend
FRONTEND_OUTPUT = src/main/resources/static

clean-frontend:
	rm -rf $(FRONTEND_OUTPUT)
clean: clean-frontend
	gradle clean
frontend:
	cd $(FRONTEND_FOLDER); ng build
run-frontend:
	cd $(FRONTEND_FOLDER); ng serve
build: frontend
	gradle build
run: build
	gradle run
