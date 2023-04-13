package org.jcmgb.veganizer.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClientBuilder;
import com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import com.amazonaws.services.securitytoken.model.Credentials;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import software.amazon.awssdk.regions.Region;

@Configuration
@EnableDynamoDBRepositories(basePackages = "org.jcmgb.veganizer.repositories")
public class DynamoDbConfig {

    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
//        String roleARN = "arn:aws:iam::286959120391:role/DemoUser";
//        String roleSessionName = "Session1";

//        AssumeRoleRequest roleRequest = new AssumeRoleRequest()
//                .withRoleArn(roleARN)
//                .withRoleSessionName(roleSessionName)
//                .withDurationSeconds(3600);

        AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials());
        if (!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
        }
        return amazonDynamoDB;
    }

//    @Bean
    public AWSCredentials amazonAWSCredentials() {
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
//        amazonAWSAccessKey = temporaryCredentials.getAccessKeyId();
//        amazonAWSSecretKey = temporaryCredentials.getSecretAccessKey();

        return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
    }
}
