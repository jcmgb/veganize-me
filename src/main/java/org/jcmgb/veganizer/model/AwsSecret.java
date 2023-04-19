package org.jcmgb.veganizer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AwsSecret {

    private String veganizemeApiKey;
    private String veganizemeApiSecret;

    public String getVeganizemeApiKey() {
        return veganizemeApiKey;
    }

    public String getVeganizemeApiSecret() {
        return veganizemeApiSecret;
    }
}


