package com.lhf.mango;

import com.lhf.mango.dao.UserNickNameDao;
import com.lhf.mango.entity.UserNickName;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;

/**
 * @ClassName: MangoDemo3
 * @Desc:
 * @Author: liuhefei
 * @Date: 2018/12/28 9:23
 */
public class MangoDemo3 {

    public static void main(String[] args){
        //定义数据源
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example?useSSL=false";
        String username = "root";
        String passowrd = "root";
        DataSource ds = new DriverManagerDataSource(driverClassName,url, username, passowrd);
        Mango mango = Mango.newInstance(ds);  //使用数据源初始化mango
        UserNickNameDao dao = mango.create(UserNickNameDao.class);
        UserNickName userNickName = new UserNickName();

        String str = "缘,起,诗,离,画,这,岁,月,记,忆,章,终,时,光,无,法,触,及,红,尘,曾,经,你,我,一,别,经,年,可,风,里,总,有,段,美,丽,会,与,不,期,而,遇,盏,琉,璃,半,杯,心,悦,端,然,着,那,份,醉,人,静,安,行,走,流,总,会,被,过,往,赋,予,清,喜,浪,漫,或,许,习,惯,了,着,布,衣,素,颜,让,清,心,若,雪,喜,张,扬,畏,喧,哗,守,怀,自,己,素,韵,安,静,中,半,亩,桃,源,修,篱,种,菊,喜,欢,山,水,相,依,流,水,对,话,让,文,字,墨,香,依,附,在,心,灵,每,角,落,闲,时,端,坐,光,隅,将,书,读,到,盏,茶,喝,到,味,故,事,看,到,泪,心,染,尘,香,须,多,少,柔,情,话,语,去,讲,只,要,能,够,念,起,便,温,暖,再,打,开,记,忆,栅,栏,取,壶,往,昔,疼,触,惜,挥,手,袖,风,里,滋,养,忧,伤,捻,缕,清,芬,三,千,浮,华,历,往,素,淡,清,雅,研,池,墨,香,植,于,眉,相,遇,如,梦,充,满,虔,诚,无,暇,打,开,文,字,苍,白,灵,动,心,事,穿,过,岁,月,轩,窗,迎,面,而,来,未,离,开,世,间,繁,华,葱,笼,容,易,沧,桑,让,所,有,如,逝,水,匆,遥,远,天,涯,河,江,海,湖,泊,淡,泊,宁,盈,诗,意,赴,许,下,盟,誓,离,开,叶,落,美,梦,想,云,水,长,韶,华,已,老,岁,月,早,已,沧,桑,习,惯,了,默,独,舞,忧,伤,然,眼,凝,眸,却,注,定,得,世,相,随,烟,花,绚,烂,忽,发,现,悄,然,呼,出,想,念,里,夏,调,谢,秋,浓,空,气,冬,雨,过,清,新,沾,染,沧,桑,凉,邂,逅,言,守,望,烟,轮,回,成,全,涯,相,依,总,会,随,风,那,些,忧,伤,叹,息,深,夜,依,然,会,被,突,如,喧,嚣,触,痛,星,铭,刻,沙,漏,渐,滤,最,初,繁,给,予,既,懂,得,须,言,永,留,心,间,感,谢,岁,月,赠,予,恩,宠,亦,感,谢,你,让,途,径,生,命,四,季,陪,程,遇,借,云,淡,风,轻,掬,捧,水,月,在,手,沾,岁,月,花,香,满,衣,慎,重,在,相,逢,渡,口,写,下,回,忆,精,彩,问,情,深,浅,遇,见,相,伴,理,由,日,落,烟,霞,菜,草,十,赵,刘,周,王,孙,宋,张,李,程,成,陈,趁,城,诚,晨,舟,周,洲,粥,轴,咒,皱,胖,小,笑,宵,晓,开,罗,何,风,峰,封,丰,枫,七,八,九,五,四,二,兔,土,雪,虚,若,弱,渃,如,霞,侠,可,青,丝,斯,思,似,屏,凭,瓶,萍,苹,拉,蜡,辣,夜,叶,钱,吴,楼,露,娄,求,清,配,酒,贩,卖,樱,葬,礼,徘,徊,物,质,爱,海,迟,树,藤,岛,鸢,尾,倒,影,微,痞,女,孩,過,去,再,見,禁,心,尽,力,许,未,来,旅,行,遗,留,忧,伤,劣,性,失,格,最,好,笨,告,白,挽,梦,忆,笙,歌,流,絮,语,荒,凉,如,歌,沉,溺,蘸,点,软,妹,酱,尽,揽,少,女,心,跟,空,气,撒,个,娇,风,歌,姬,朝,思,暮,想,菲,薄,春,寻,找,归,宿,盛,夏,倾,情,需,要,季,节,靠,谱,追,忆,昔,年,解,释,感,情,溺,于,千,纸,鹤,甜,度,酒,窝,偷,走,满,目,温,柔,樱,花,向,日,葵,約,定,蓝,红,黑,嘿,粉,紫,梓,滋,恣,逆,蒲,公,英,凉,夜,微,冷,沉,溺,記,柔,刀,萌,吟,桃,酥,萝,莉,陌,上,柳,絮,傾,城,雪,繁,华,笙,歌,落,左,右,霜,孀,酒,旧,玖,玫,瑰,丁,香,彼,岸,芙,蓉,茉,莉,楼,兰,桂,东,南,西,北,酒,醉,碎,不,碰,触,伤,谢,忽,如,雾,浅,笶,掩,饰,泪,光,梦,醒,梦,碎,残,梦,凉,心,呼,吸,都,痛,想,念,终,究,叶,落,无,声,香,中,萧,鼓,疏,烟,淡,日,楚,峡,云,归,千,江,有,水,千,江,月,潇,潇,暮,雨,海,阔,山,遥,神,祗,与,歌,霜,冷,长,河,清,风,笑,烟,雨,阅,尽,尘,寰";
        String[] strArr = str.split(",");
        int num = 0;
        for(int i=0;i< strArr.length;i++){
            System.out.println(strArr[i]);
            userNickName.setNickname(strArr[i]);
            num = dao.insertNickName(userNickName);
            num++;
        }
        System.out.println("num = " + num);
    }
}
