package win.haotianyi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by 天 on 2017/7/12.
 */
public class LocalProperty {
    private static final String LOCAL_PROPERTIES = "local.properties";

    private String accessKey;
    private String secretKey;
    private String bucketName;
    private String domainName;

    public static LocalProperty getLocalProperty() {
        File localProperties = new File(LOCAL_PROPERTIES);
        if (localProperties.exists() && localProperties.canRead()) {
            String properties = Utils.getStringFromFile(localProperties,
                    "UTF-8");
            return (LocalProperty) GsonUtil.getInstance().fromJson(properties,
                    LocalProperty.class);
        }
        return null;
    }

    public static LocalProperty getLocalPropertyByConsole(){
        String accessKey = "xxxxxxxxxxxx";//就是ak
        String secretKey = "xxxxxxxxxx";//就是sk
        String bucketName = "xxxxxxxx";//存储空间的名称
        String domainName = "xxxxxxxxx";//存储域名

        LocalProperty localProperty = new LocalProperty();
        localProperty.setAccessKey(accessKey);
        localProperty.setSecretKey(secretKey);
        localProperty.setBucketName(bucketName);
        localProperty.setDomainName(domainName);
        localProperty.saveLocalProperty();
        return localProperty;
    }

    public void saveLocalProperty() {
        File localProperties = new File(LOCAL_PROPERTIES);

        if (!localProperties.exists()) {
            String jsonString = GsonUtil.getInstance().toJson(this);
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(
                        localProperties));
                writer.write(jsonString);
                writer.flush();
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Utils.println("File exits ! " + localProperties.getAbsolutePath());
        }
    }

    public String getImageUrl(String fileName) {
        return "http://" + getDomainName().trim() + "/" + fileName;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String toString() {
        return "LocalProperty [accessKey=" + accessKey + ", secretKey="
                + secretKey + ", bucketName=" + bucketName + ", domainName="
                + domainName + "]";
    }
}
