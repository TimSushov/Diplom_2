package resours.responseData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {
    private String _id;
    private String name;
    private String type;
    private int proteins;
    private int fat;
    private int carbohydrates;
    private int calories;
    private int price;
    private String image;
    private String image_mobile;
    private String image_large;
    private int __v;

    public Data(){};
}
