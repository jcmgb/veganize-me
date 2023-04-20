# veganize-me

# Overview

Welcome to Veganize Me!  We created this app on our free time to help foodies veganize their favorite recipes.  We are 
a team of two tech-savvy vegetarians who are passionate about vegan food, coding, continuously improving this app, and 
covering all the roles (PM, UI designer, developer, tester, DevOps, etc).

Frameworks: Angular/Typescript (front end), Java on Spring Boot (back end)
<br>Data Store: AWS DynamoDB

# What the application currently does
- Lists already veganized recipes by title.
- Persists veganized recipes.
- Veganizes a recipe based on provided ingredients list.
- Provides a copy-to-clipboard option to copy recipe contents immediately after it is veganized.

# Planned enhancements to the application
- Search capability of veganized recipe by title
- Recipe contents enhancements:
  - HTML page
  - Copy contents
  - Share link
- Expansion of vegan sub ingredients
________________________

# How to build and run Veganize Me!

## In prod
- Veganize Me! is running live at http://veganizeme-angular-app.s3-website-us-east-1.amazonaws.com/

## Locally
- Start the back end: 
  - From command line, run <div style="font-family: courier;">gradlew.bat -D'spring.profiles.active=local' bootRun</div>
  - Endpoints are now accessible via PostMan from port :8080
- Start the front end:
  - Navigate to veganizer-ui
  - From command line, run <div style="font-family: courier;">ng serve --configuration=development</div>
  - From browser, navigate to http://localhost:4200

## Build and deploy to prod
- Back end:
  - From command line, run <div style="font-family: courier;">gradlew.bat clean build</div>
  - Upload to AWS Elastic Beanstalk environment the jar file <div style="font-family: courier;">build/libs/veganize-me-1.0-SNAPSHOT.jar</div>
- Front end:
  - Navigate to veganizer-ui
  - From command line, run <div style="font-family: courier;">ng build</div>
  - Upload to application S3 bucket the files in dist/veganizer-ui
