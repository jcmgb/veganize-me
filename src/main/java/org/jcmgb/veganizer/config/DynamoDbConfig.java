package org.jcmgb.veganizer.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClientBuilder;
import com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import com.amazonaws.services.securitytoken.model.Credentials;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;

@Configuration
@EnableDynamoDBRepositories(basePackages = "org.jcmgb.veganizer.repository")
public class DynamoDbConfig {

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withRegion(Region.US_EAST_1.toString())
                .withCredentials(amazonAWSCredentials())
                .build();
    }

    public AWSCredentialsProvider amazonAWSCredentials() {
        String roleARN = "arn:aws:iam::286959120391:role/MGB-dynamoDb-assumeRole";
        String roleSessionName = "Session1";

        AWSSecurityTokenService stsClient = AWSSecurityTokenServiceClientBuilder
                .standard()
                .withRegion(Region.US_EAST_1.toString())
                .build();

        AssumeRoleRequest roleRequest = new AssumeRoleRequest()
                .withRoleArn(roleARN)
                .withRoleSessionName(roleSessionName)
                .withDurationSeconds(3600);
        AssumeRoleResult assumeResult = stsClient.assumeRole(roleRequest);
        Credentials temporaryCredentials = assumeResult.getCredentials();

        AWSCredentials basicSessionCreds = new BasicSessionCredentials(
                temporaryCredentials.getAccessKeyId(),
                temporaryCredentials.getSecretAccessKey(),
                temporaryCredentials.getSessionToken());

        return new AWSStaticCredentialsProvider(basicSessionCreds);
    }
}
