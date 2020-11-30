package com.baizhi.yingx_jiagh;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class YingxJiaghApplicationTests {

    @Test
    void contextLoads() {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
        String accessKeyId = "LTAI4GECUe6rMQdn538rAPg5";
        String accessKeySecret = "eYbNG98bgzDDNP5FmzUuuITLo41on0";
        String bucketName="yx-2005";  //存储空间名  yingx-2005
        String objectName="a.jpg";  //保存的文件名   1.MP4  aaa.mp4
        String localFile="C:\\Users\\jiagu\\Desktop\\2.作业.jpg";   //本地文件位置

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 创建PutObjectRequest对象。
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, new File(localFile));

        // 上传文件。
        ossClient.putObject(putObjectRequest);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

}
