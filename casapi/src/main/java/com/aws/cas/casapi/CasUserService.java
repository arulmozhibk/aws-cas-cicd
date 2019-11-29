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
        CasUsers allusers = new CasUsers(userlist);

        return allusers;
    }

    public CasUsers queryUserItems(String filter, String value) {

        HashMap<String, AttributeValue> attribValue = new HashMap<String, AttributeValue>();
        attribValue.put(":"+value,  new AttributeValue().withS(value));

        DynamoDBQueryExpression<CasUser> queryExpression = new DynamoDBQueryExpression<CasUser>()
                .withIndexName(filter+"Index")
                .withKeyConditionExpression(filter + "= :" + value)
                .withExpressionAttributeValues(attribValue)
                .withConsistentRead(false);

        List<CasUser> users = mapper.query(CasUser.class, queryExpression);
        CasUsers allusers = new Mysfits(users);

        return allusers;
    }
}