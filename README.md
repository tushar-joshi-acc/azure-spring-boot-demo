# Demo for Spring Boot App with Azure App Services (PaaS)

### Steps to create the sample app on App Services 
#### Create an account on MS Azure - 
https://azure.microsoft.com/free/?ref=microsoft.com&utm_source=microsoft.com&utm_medium=docs&utm_campaign=visualstudio

Once you have an account for Azure, create a sample Web App on App Services (PaaS for Azure). Follow these steps - 

1. Click on App Services

2. Create Web Services, fill in app name and other details

3. Select the type as Java 11 and Java SE

#### GitHub SCM and GitHub Actions for CI/CD

1. Select Source Control as GitHub

2. Authenticate with your GitHub account, allow access for your account to MS Azure.

3. Once authenticated, you can see your repositories, select appropriate repository, the code base that you would like to deploy on Azure websites.

4. Select CI/CD provider as GitHub Actions. Click 'Continue'.

5. Azure creates the build and deploy steps for GitHub Actions in the github workflow directory as '.yml' file.

#### Use with Gradle! 

1. Add Following in the yml build file instead of mvn command - 
   ######
       - name: Enable gradle build
         run: chmod +x ./gradlew
         
       - name: Build with Gradle
         run: ./gradlew build

2. Change the source of the deployable JAR according to Gradle
   ######
       - name: Deploy to Azure Web App
         uses: azure/webapps-deploy@v2
         with:
           app-name: '<your_app_name>'
           slot-name: 'production'
           publish-profile: ${{ secrets.AzureAppService_PublishProfile_<somr_random_hash_auto_generated_bu_azure> }}
           package: '${{ github.workspace }}/build/libs/*.jar'
               
3. Commit your changes. On Push event, new App gets deployed on Azure!