<<<<<<< HEAD
# Bicaraku :open_hands:

## Application Description & Background
Bicaraku is an application that can help people to communicate with the deaf and mute using sign language. The main goal of this application is to increase ordinary people's knowledge of sign language and make it easier for people who do not understand sign language to communicate with deaf and mute disabled people without any restrictions. Although learning sign language takes time to learn and understand, it is hoped that this application can help provide easy-to-use tools for the deaf and mute in communicating with others, so that they are not only able to communicate with certain people.

---
## Scope & Deliverables
There are many types of sign languages used around the world, but we only limited the app to detect SIBI (Sistem Isyarat Bahasa Indonesia) sign language only. This application has 2 main features and 1 additional feature. 
  1. Detect sentences from the SIBI sign language alphabet. 
  2. The SIBI sign language alphabet learning feature using moving images or GIFs. 
  3. There are additional features, namely detecting SIBI sign language based on words that are often used.
=======
<<<<<<< HEAD
# Bicaraku
=======
# CodeIgniter 4 Application Starter

## What is CodeIgniter?

CodeIgniter is a PHP full-stack web framework that is light, fast, flexible and secure.
More information can be found at the [official site](https://codeigniter.com).

This repository holds a composer-installable app starter.
It has been built from the
[development repository](https://github.com/codeigniter4/CodeIgniter4).

More information about the plans for version 4 can be found in [CodeIgniter 4](https://forum.codeigniter.com/forumdisplay.php?fid=28) on the forums.

The user guide corresponding to the latest version of the framework can be found
[here](https://codeigniter4.github.io/userguide/).

## Installation & updates

`composer create-project codeigniter4/appstarter` then `composer update` whenever
there is a new release of the framework.

When updating, check the release notes to see if there are any changes you might need to apply
to your `app` folder. The affected files can be copied or merged from
`vendor/codeigniter4/framework/app`.

## Setup

Copy `env` to `.env` and tailor for your app, specifically the baseURL
and any database settings.

## Important Change with index.php

`index.php` is no longer in the root of the project! It has been moved inside the *public* folder,
for better security and separation of components.

This means that you should configure your web server to "point" to your project's *public* folder, and
not to the project root. A better practice would be to configure a virtual host to point there. A poor practice would be to point your web server to the project root and expect to enter *public/...*, as the rest of your logic and the
framework are exposed.

**Please** read the user guide for a better explanation of how CI4 works!

## Repository Management

We use GitHub issues, in our main repository, to track **BUGS** and to track approved **DEVELOPMENT** work packages.
We use our [forum](http://forum.codeigniter.com) to provide SUPPORT and to discuss
FEATURE REQUESTS.

This repository is a "distribution" one, built by our release preparation script.
Problems with it can be raised on our forum, or as issues in the main repository.

## Server Requirements

PHP version 7.4 or higher is required, with the following extensions installed:

- [intl](http://php.net/manual/en/intl.requirements.php)
- [mbstring](http://php.net/manual/en/mbstring.installation.php)

Additionally, make sure that the following extensions are enabled in your PHP:

- json (enabled by default - don't turn it off)
- [mysqlnd](http://php.net/manual/en/mysqlnd.install.php) if you plan to use MySQL
- [libcurl](http://php.net/manual/en/curl.requirements.php) if you plan to use the HTTP\CURLRequest library
>>>>>>> 95254d1 (Kamus Bicaraku)
>>>>>>> 339ce3b (Kamus Bicaraku)
