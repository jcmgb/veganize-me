package org.jcmgb.veganizer.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.google.gson.Gson;
import org.jcmgb.veganizer.model.AwsSecret;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

@Configuration
@EnableDynamoDBRepositories(basePackages = "org.jcmgb.veganizer.repository")
public class DynamoDbConfig {
    private Gson gson = new Gson();

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {

        AwsSecret userKeys = getKeys();
        AWSStaticCredentialsProvider creds = new AWSStaticCredentialsProvider(
                new BasicAWSCredentials(
                        userKeys.getVeganizemeApiKey(),
                        userKeys.getVeganizemeApiSecret())
        );

        return AmazonDynamoDBClientBuilder
                .standard()
                .withRegion(Region.US_EAST_1.toString())
                .withCredentials(creds)
                .build();
    }

    private AwsSecret getKeys() {

        String secretName = "veganizeme-aws-api";
        String regionStr = "us-east-1";
        Region region = Region.of(regionStr);

        // Create a Secrets Manager client
        SecretsManagerClient client = SecretsManagerClient.builder()
                .region(region)
                .build();

        GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
                .secretId(secretName)
                .build();

        GetSecretValueResponse getSecretValueResponse;

        try {
            getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
        } catch (Exception e) {
            // For a list of exceptions thrown, see
            // https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
            throw e;
        }

        String secret = getSecretValueResponse.secretString();
        return gson.fromJson(secret, AwsSecret.class);
    }
}
