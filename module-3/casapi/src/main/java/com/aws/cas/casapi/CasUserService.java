package com.aws.cas.casapi;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class CasUserService{


    private final AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
    private DynamoDBMapper mapper = new DynamoDBMapper(client);

    public CasUsers getUserList() {

        List<CasUser> userlist = mapper.scan(CasUser.class, new DynamoDBScanExpression());
        CasUsers alluser = new CasUsers(userlist);

        return alluser;
    }

    public CasUsers queryUserItems(String filter, String value) {

        HashMap<String, AttributeValue> attribValue = new HashMap<String, AttributeValue>();
        attribValue.put(":"+value,  new AttributeValue().withS(value));
        
                String indexPref="orgId";
        if((filter.equalsIgnoreCase( "SG" )) || (filter.equalsIgnoreCase( "HK" ))|| (filter.equalsIgnoreCase( "IN" ) )){
            indexPref="group";
        }
        
        DynamoDBQueryExpression<CasUser> queryExpression = new DynamoDBQueryExpression<CasUser>()
                .withIndexName(indexPref+"Index")
                .withKeyConditionExpression(indexPref + "= :" + value)
                .withExpressionAttributeValues(attribValue)
                .withConsistentRead(false);

        List<CasUser> users = mapper.query(CasUser.class, queryExpression);
        CasUsers alluserslist = new CasUsers(users);

        return alluserslist;
    }
}