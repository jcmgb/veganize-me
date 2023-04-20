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
  - From command line, run <code>gradlew.bat -D'spring.profiles.active=local' bootRun</code>
  - Endpoints are now accessible via PostMan from port <code>:8080</code>
- Start the front end:
  - Navigate to <code>veganizer-ui</code>
  - From command line, run 
  <br><code>rm node-modules</code>
  <br><code>npm install</code>
  <br><code>ng serve --configuration=development</code>
  - From browser, navigate to http://localhost:4200

## Build and deploy to prod
- Back end:
  - From command line, run <code>gradlew.bat clean build</code>
  - Upload to AWS Elastic Beanstalk environment the jar file <code>build/libs/veganize-me-1.0-SNAPSHOT.jar</code>
- Front end:
  - Navigate to <code>veganizer-ui</code>
  - From command line, run <code>ng build</code>
  - Upload to application S3 bucket the files in <code>dist/veganizer-ui</code>
