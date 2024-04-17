package com.trabajoFinal.trabajoFinal.services;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.model.Region;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;

@Service
public class S3Service {
/*

    @Value("${aws.accessKey}")
    private String awsAccessKey;

    @Value("${aws.secretKey}")
    private String awsSecretKey;

    private final static String BUCKET = "contenedor-aplicacion-tienda";


    public S3Service(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    public String uploadFile(MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            PutObjectRequest request = new PutObjectRequest(bucketName, fileName, file.getInputStream(), metadata);
            PutObjectResult result = amazonS3.putObject(request);
            return amazonS3.getUrl(bucketName, fileName).toString();
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de excepciones
            return null;
        }
    }

    public InputStream getImage(String imageName) {
        try {
            BasicAWSCredentials awsCredentials = new BasicAWSCredentials(awsAccessKey, awsSecretKey);
            AmazonS3 amazonS3 = AmazonS3ClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                    .withRegion(awsRegion)  // Pasar el nombre de la región como una cadena
                    .build();
            S3Object object = amazonS3.getObject(BUCKET, imageName);
            return object.getObjectContent();
        } catch (AmazonClientException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
            return null;
        }
    }

 */

}
