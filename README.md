# webPresentation
Create Web Presentation online.

You can create documentation or informatión about a topic.
# Instalation

```
	$mongod &
	$mongo
	>db.user.insert({
		"user": "admin",
	    "password": "7fcf4ba391c48784edde599889d6e3f1e47a27db36ecc050cc92f259bfac38afad2c68a1ae804d77075e8fb722503f3eca2b2c1006ee6f6c7b7628cb45fffd1d",
	    "name": "Administrador",
	    "email": "admin@dventura.net",
	    "enable": true,
	    "roles": [
	        "ADMIN",
	        "CLIENT"
	    ]
	})
	>exit
	$git clone https://github.com/dventura11/webPresentation
	cd webPresentation
	$gradle -Dskip.tests run
```
open [localhost:8080](http:localhost:8080)

Default user and password:
	admin
	admin123

# Edition
```
	$gradle build
	$vim ~/.vimrc
```
Add the next lines and save
```
	let g:syntastic_java_checkers=['javac']
	let g:syntastic_java_javac_config_file_enabled = 1
```

You need install before syntastic plugin:
[syntastic](https://github.com/scrooloose/syntastic)
