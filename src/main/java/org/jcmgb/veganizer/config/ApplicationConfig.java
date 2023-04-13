//package org.jcmgb.veganizer.config;
//
//import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
//import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClientBuilder;
//import com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
//import com.amazonaws.services.securitytoken.model.AssumeRoleResult;
//import com.amazonaws.services.securitytoken.model.Credentials;
//import com.google.gson.Gson;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import software.amazon.awssdk.regions.Region;
//
//@Configuration
//public class ApplicationConfig {
//    public Gson gson = new Gson();
//    @Bean
//    public void getToken() {
//        String roleARN = "arn:aws:iam::286959120391:role/DemoUser";
//        String roleSessionName = "Session1";
//
//        AWSSecurityTokenService stsClient = AWSSecurityTokenServiceClientBuilder
//                .standard()
//                .withRegion(Region.US_EAST_1.toString())
//                .build();
//
//        AssumeRoleRequest roleRequest = new AssumeRoleRequest()
//                .withRoleArn(roleARN)
//                .withRoleSessionName(roleSessionName)
//                .withDurationSeconds(3600);
//        AssumeRoleResult assumeResult = stsClient.assumeRole(roleRequest);
//        Credentials temporaryCredentials = assumeResult.getCredentials();
//
//        System.out.println("ACCESS_KEY_ID = " + temporaryCredentials.getAccessKeyId());
//        System.out.println("SECRET_ACCESS_KEY = " + temporaryCredentials.getSecretAccessKey());
//        System.out.println("SESSION_TOKEN = " + temporaryCredentials.getSessionToken());
//    }
//}
