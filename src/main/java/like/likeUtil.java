package like;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liziqiang
 * @description: likeUtil
 * @date: 2021/3/2 下午3:54
 */
public class likeUtil {

    public static void main(String[] args) {

        List<ActivityMaterials> resultList = new ArrayList<>();
        ActivityMaterials a = new ActivityMaterials();
        a.setMaterialsSource("奥迪,方式方法");
        resultList.add(a);
        ActivityMaterials b = new ActivityMaterials();
        b.setMaterialsSource("地方为俄文");
        resultList.add(b);

        String materialSource= "方";

        System.out.println(b.getMaterialsSource().contains(materialSource));


        //String materialsName= "名字";
        if(!StringUtils.isEmpty(materialSource)){
            List<String> temp = new ArrayList<>();
            for (ActivityMaterials materials: resultList) {
                if (materials.getMaterialsSource().contains(materialSource)){
                    temp.add(materials.getMaterialsSource());
                }
                /*
                String[] source = StringUtils.split(materialSource," \t\\/,.;，。；");
                System.out.println("source:" + source);
                if (source != null && source.length>=1){
                    for(String key : source) {
                        if (materials.getMaterialsSource().contains(key)){

                            temp.add(materials);
                        }
                    }
                }
                System.out.println("temp:" + temp.toString());
                String[] name = StringUtils.split(materialsName,"\t\\/,.;，。；");
                if (name != null && name.length>=1){
                    for(String key : name) {
                        if (materials.getMaterialsSource().contains(key)){
                            temp.add(materials);
                        }
                    }
                }*/
            }
            System.out.println("temp:" + temp.toString());
        }





    }



}
