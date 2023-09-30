package com.example.a4foods.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String TEN_DATABASE= "Foodstore";

    //Bang Product
    public static final String TEN_BANG_PRODUCTS = "Product";
    public static final String COT_ID_PRO = "_Id";
    public static final String COT_NAME_PRO = "_NamePro";
    public static final String COT_CATEGORY = "_Category";
    public static final String COT_BRAND_PRO = "_Brand";
    public static final String COT_DESCRIPTION_PRO = "_DescriptionPro";
    public static final String COT_PRICE = "_Price";
    public static final String COT_IMAGE_PRO = "_ImagePro";
    public static final String COT_SIZE_PRO = "_SizePro"; //cột nước
    public static final String COT_COLOR_PRO = "_ColorPro"; //cột đồ ăn kèm



    //Bang Brand
    public static final String TEN_BANG_BRAND = "Brand";
    public  static  final String COT_ID_BRAND = "_IdBrand";
    public  static  final String COT_NAME_BRAND = "_NameBrand";
    public  static  final String COT_IMAGE_BRAND = "_ImageBrand";


    //Bang Caterogy
    public static final String TEN_BANG_CATEGORY = "Category";
    public  static  final String COT_ID_CATEGORY = "_IdCate";
    public  static  final String COT_NAME_CATEGORY = "_NameCate";


    //Bang Cart
    public static final String TEN_BANG_CART = "CartPro";
    public static final String COT_ID_CART = "_IdCart";
    public static final String COT_ID_Pro = "_IdPro";
    public static final String COT_ID_User = "_IdUser";
    public static final String COT_QUANTITY = "_Quantity";
    public static final String COT_COLOR_CART = "_ColorCart";
    public static final String COT_SIZE_CART = "_SizeCart";



    //Bang User
    public static final String TEN_BANG_USER = "User";
    public static final String COT_ID_USER = "_IdUser";
    public static final String COT_NAME_USER = "_Name";
    public static final String COT_EMAIL_USER = "_Email";
    public static final String COT_PASS_USER = "_Password";
    public static final String COT_PHONE_USER = "_Phone";
    public static final String COT_ADDRESS_USER = "_Address";
    public static final String COT_ROLE_USER = "_Role";


    //Bang Order
    public static final String TEN_BANG_ORDER = "OrderPro";
    public static final String COT_ID_ORDER = "_IdOrder";
    public static final String COT_DATE_ORDER = "_DateOder";
    public static final String COT_ID_Pro_Order = "_IdPro";
    public static final String COT_ID_User_Order = "_IdUser";
    public static final String COT_QUANTITY_Order = "_Quantity";
    public static final String COT_COLOR_Order = "_ColorOrder";
    public static final String COT_SIZE_Order = "_SizeOrder";
    public static final String COT_NAME_Order = "_NameOrder";
    public static final String COT_PHONE_Order = "_PhoneOrder";
    public static final String COT_ADDRESS_Order = "_AddressOrder";
    public static final String COT_STATUS_Order = "_StatusOrder";



    private static final String TAO_BANG_BRAND = ""
            + "CREATE TABLE " + TEN_BANG_BRAND + " ( "
            + COT_ID_BRAND + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COT_NAME_BRAND + " TEXT, "
            + COT_IMAGE_BRAND + " TEXT ) ";

    private static final String TAO_BANG_CATEGORY = ""
            + "CREATE TABLE " + TEN_BANG_CATEGORY + " ( "
            + COT_ID_CATEGORY + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COT_NAME_CATEGORY + "	TEXT ) ";


    private static final String TAO_BANG_CART = ""
            + "CREATE TABLE " + TEN_BANG_CART + " ( "
            + COT_ID_CART + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COT_ID_Pro + " INTEGER, "
            + COT_ID_User + " INTEGER, "
            + COT_QUANTITY + " INTEGER, "
            + COT_COLOR_CART + " TEXT, "
            + COT_SIZE_CART + " TEXT, "
            + "FOREIGN KEY(" + COT_ID_Pro + ") REFERENCES " + TEN_BANG_PRODUCTS + "(" + COT_ID_PRO + "), "
            + "FOREIGN KEY(" + COT_ID_User + ") REFERENCES " + TEN_BANG_USER + "(" + COT_ID_USER + ") ) ";


    private static final String TAO_BANG_USER = ""
            + "CREATE TABLE " + TEN_BANG_USER + " ( "
            + COT_ID_USER + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COT_NAME_USER + " TEXT, "
            + COT_EMAIL_USER + " TEXT, "
            + COT_PASS_USER + " TEXT, "
            + COT_PHONE_USER + " TEXT, "
            + COT_ADDRESS_USER + " TEXT, "
            + COT_ROLE_USER + " INTEGER ) ";


    private static final String TAO_BANG_PRODUCT = ""
            + "CREATE TABLE " + TEN_BANG_PRODUCTS + " ( "
            + COT_ID_PRO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COT_NAME_PRO + " TEXT, "
            + COT_DESCRIPTION_PRO + " TEXT, "
            + COT_CATEGORY + " INTEGER, "
            + COT_BRAND_PRO + " INTEGER, "
            + COT_PRICE + " INTEGER, "
            + COT_IMAGE_PRO + " TEXT, "
            + COT_SIZE_PRO + " TEXT, "
            + COT_COLOR_PRO + " TEXT, "
            + "FOREIGN KEY(" + COT_BRAND_PRO + ") REFERENCES " + TEN_BANG_BRAND + "(" + COT_ID_BRAND + "), "
            + "FOREIGN KEY(" + COT_CATEGORY + ") REFERENCES " + TEN_BANG_CATEGORY + "(" + COT_ID_CATEGORY + ") ) ";


    private static final String TAO_BANG_ORDER = ""
            + "CREATE TABLE " + TEN_BANG_ORDER + " ( "
            + COT_ID_ORDER + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COT_ID_User_Order + " INTEGER, "
            + COT_ID_Pro_Order + " INTEGER, "
            + COT_QUANTITY_Order + " INTEGER, "
            + COT_DATE_ORDER + " TEXT, "
            + COT_COLOR_Order + " TEXT, "
            + COT_SIZE_Order + " TEXT, "
            + COT_NAME_Order + " TEXT, "
            + COT_PHONE_Order + " TEXT, "
            + COT_ADDRESS_Order + " TEXT, "
            + COT_STATUS_Order + " INTEGER, "
            + "FOREIGN KEY(" + COT_ID_Pro_Order + ") REFERENCES " + TEN_BANG_PRODUCTS + "(" + COT_ID_PRO + "), "
            + "FOREIGN KEY(" + COT_ID_User_Order + ") REFERENCES " + TEN_BANG_USER + "(" + COT_ID_USER + ") ) ";


    public DBHelper(Context context) {
        super(context, TEN_DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TAO_BANG_PRODUCT);
        sqLiteDatabase.execSQL(TAO_BANG_BRAND);
        sqLiteDatabase.execSQL(TAO_BANG_CATEGORY);
        sqLiteDatabase.execSQL(TAO_BANG_USER);
        sqLiteDatabase.execSQL(TAO_BANG_CART);
        sqLiteDatabase.execSQL(TAO_BANG_ORDER);

        THEM_DU_LIEU(sqLiteDatabase);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    private void THEM_DU_LIEU(SQLiteDatabase sqLiteDatabase)
    {

        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_CATEGORY + " (" + COT_NAME_CATEGORY + ") VALUES ('Gợi ý');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_CATEGORY + " (" + COT_NAME_CATEGORY + ") VALUES ('Mua nhiều');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_CATEGORY + " (" + COT_NAME_CATEGORY + ") VALUES ('Món mới');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_CATEGORY + " (" + COT_NAME_CATEGORY + ") VALUES ('Ngẫu nhiên');");

        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_BRAND + " (" + COT_NAME_BRAND + "," + COT_IMAGE_BRAND + ") VALUES ('Combo', 'comboback.jpg');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_BRAND + " (" + COT_NAME_BRAND + "," + COT_IMAGE_BRAND + ") VALUES ('Cơm', 'comback.jpg');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_BRAND + " (" + COT_NAME_BRAND + "," + COT_IMAGE_BRAND + ") VALUES ('Salad', 'saladback.jpg');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_BRAND + " (" + COT_NAME_BRAND + "," + COT_IMAGE_BRAND + ") VALUES ('Ăn vặt', 'anvatback.jpg');");


        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_USER + " (" + COT_NAME_USER + "," + COT_EMAIL_USER + "," + COT_PASS_USER + "," +  COT_ADDRESS_USER + "," + COT_PHONE_USER + "," + COT_ROLE_USER + ") VALUES ('Admin', 'admin', 'admin', null, null, 1);");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_USER + " (" + COT_NAME_USER + "," + COT_EMAIL_USER + "," + COT_PASS_USER + "," +  COT_ADDRESS_USER + "," + COT_PHONE_USER + "," + COT_ROLE_USER + ") VALUES ('dat', 'dat', 'dat', 'HUFLIT', '0123456789', null);");



        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Combo 1', 1, 1, 70000, 'combo1.jpg', 'Cocacola 7up Cam Sting', 'Không Rau_sống'"
                + ",'Combo 1: 1 đùi gà chiên lớn + 1 coca + 1 Khoai tây chiên');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Combo 2', 1, 1, 80000, 'combo2.jpg', 'Cocacola 7up Cam Sting', 'Không Rau_sống Đồ_chua'"
                + ",'Combo 2: cơm sườn, chả + nước 1 người ăn. Sườn nướng chín tới kết hợp với cơm tấm ăn kèm với đồ chua. Đã có săn canh rong biển và món ăn vặt trong combo. Combo đầy đủ cho 1 người ăn vô tư.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Cơm gà miếng', 1, 2, 35000, 'comgamieng.jpg', 'Không Cocacola 7up Cam Sting', 'Không Rau_sống Đồ_chua'"
                + ",'Cơm gà là món ăn được nhiều người yêu thích, bởi hương vị thơm ngon, cơm vàng ươm nhìn bắt mắt, da gà giòn giòn ăn kết hợp thêm phần gỏi chua chua ngọt.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Combo 3', 2, 1, 90000, 'combo3.jpg', 'Cocacola 7up Cam Sting', 'Không Rau_sống'"
                + ",'Combo 3: cơm gà,trứng + nước 1 người ăn. Sườn nướng chín tới kết hợp với cơm tấm ăn kèm với đồ chua. Đã có săn canh rong biển và món ăn vặt trong combo. Combo đầy đủ cho 1 người ăn vô tư.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Combo 4', 2, 1, 100000, 'combo4.jpg', 'Cocacola 7up Cam Sting', 'Không Rau_sống'"
                + ",'Combo 4: cơm gà,trứng + nước 1 người ăn. Sườn nướng chín tới kết hợp với cơm tấm ăn kèm với đồ chua. Đã có săn canh rong biển và món ăn vặt trong combo. Combo đầy đủ cho 1 người ăn vô tư.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Combo 5', 2, 1, 100000, 'combo5.jpg', 'Cocacola 7up Cam Sting', 'Không Rau_sống'"
                + ",'Combo 5: cơm gà,trứng + nước 1 người ăn. Sườn nướng chín tới kết hợp với cơm tấm ăn kèm với đồ chua. Đã có săn canh rong biển và món ăn vặt trong combo. Combo đầy đủ cho 1 người ăn vô tư.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Combo 6', 2, 1, 100000, 'combo6.jpg', 'Cocacola 7up Cam Sting', 'Không Rau_sống'"
                + ",'Combo 4: cơm gà,trứng + nước 1 người ăn. Sườn nướng chín tới kết hợp với cơm tấm ăn kèm với đồ chua. Đã có săn canh rong biển và món ăn vặt trong combo. Combo đầy đủ cho 1 người ăn vô tư.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Combo 7', 2, 1, 100000, 'combo7.jpg', 'Cocacola 7up Cam Sting', 'Không Rau_sống'"
                + ",'Combo 4: cơm gà,trứng + nước 1 người ăn. Sườn nướng chín tới kết hợp với cơm tấm ăn kèm với đồ chua. Đã có săn canh rong biển và món ăn vặt trong combo. Combo đầy đủ cho 1 người ăn vô tư.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Cơm đùi gà', 1, 2, 40000, 'comduiga.jpg', 'Không Cocacola 7up Cam Sting', 'Không Rau_sống Đồ_chua'"
                + ",' Cơm đùi gà là món ăn được nhiều người yêu thích, bởi hương vị thơm ngon, cơm vàng ươm nhìn bắt mắt, da gà giòn giòn ăn kết hợp thêm phần gỏi chua chua ngọt.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Cơm chiên dương châu', 2, 2, 40000, 'comchienduongchau.jpg','Không Cocacola 7up Cam Sting', 'Không Rau_sống Đồ_chua'"
                + ",'Món cơm chiên Dương Châu với màu sắc đa dạng, từng hạt cơm vàng ruộm thấm gia vị mặn ngọt đậm đà, rau củ tươi ngon ngọt tự nhiên xen lẫn với lạp xưởng và chả');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Cơm chiên hải sản', 2, 2, 60000, 'comchienhaisan.jpg','Không Cocacola 7up Cam Sting', 'Không Rau_sống Đồ_chua'"
                + ",'Cơm hải sản là sự kết hợp giữa vị dai giòn của mực, vị ngọt mềm của tôm, vị thơm của gạo và vị tươi của đậu Hà Lan và bắp mang đến cho bạn hương vị thơm ngon');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Cơm chiên kim chi cá ngừ', 4, 2, 50000, 'comkimchicangu.jpg','Không Cocacola 7up Ccam Sting', 'Không Rau_sống Đồ_chua'"
                + ",'Cơm trắng được xào đều cùng với kim chi và cá ngừ, trộn đều vào nhau tạo nên hỗn hợp cơm rang màu đỏ bắt mắt.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Cơm chiên kim chi thịt bò', 4, 2, 50000, 'comchienkimchithitbo.jpg','Không Cocacola 7up Cam Sting', 'Không Rau_sống Đồ_chua'"
                + ",'Cơm kim chi thịt bò thơm ngon lạ miệng, kết hợp thật tinh tế với các gia vị cùng chút béo ngậy của trứng chiên.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Salad rau củ', 1, 3, 40000, 'saladraucu.jpg','Không Cocacola 7up Cam Sting', 'Sốt_mayonnaise Sốt_bơ'"
                + ",'Salad rau củ tốt cho sức khỏe. Phù hợp với người ăn chay');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Salad heo', 1, 3, 60000, 'saladheo.jpg','Không Cocacola 7up Cam Sting', 'Sốt_mayonnaise Sốt_bơ'"
                + ",'Salad heo tốt cho sức khỏe');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Salad cá ngừ', 2, 3, 90000, 'saladcahoi.jpg','Không Cocacola 7up Cam Sting', 'Sốt_mayonnaise Sốt_bơ'"
                + ",'Salad cá ngừ tốt cho sức khỏe');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Salad thịt bò', 2, 3, 190000, 'saladtbo.jpg','Không Cocacola 7up Cam Sting', 'Sốt_mayonnaise Sốt_bơ'"
                + ",'Salad thịt bò cobe tốt cho sức khỏe');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Salad tôm', 2, 3, 99000, 'saladtom.jpg','Không Cocacola 7up Cam Sting', 'Sốt_mayonnaise Sốt_bơ'"
                + ",'Salad tôm tươi ngon, tốt cho sức khỏe');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Cá viên chiên', 1, 4, 20000, 'cavien.jpg','Không Cocacola 7up Cam Sting', 'Tương_ớt Tương_cà Mix'"
                + ",'Cá được bắt từ đại dương, xay nhuyễn tạo thành từng viên cá. Được chiên bằng dầu');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Khoai tây chiên', 1, 4, 20000, 'khoaitaychien.jpg','Không Cocacola 7up Cam Sting', 'Tương_ớt Tương_cà Mix'"
                + ",'Khoai tây nhập khẩu từ Úc và được chiên bằng dầu ăn nhập khẩu từ Nhật bản.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Kimbap Hàn quốc', 4, 4, 1650000, 'kimbap.jpg','Không Cocacola 7up Cam Sting', 'Tương_ớt Tương_cà Mix'"
                + ",'Kimbap Hàn Quốc được làm từ Việt Nam');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Xúc xích chiên', 4, 4, 15000, 'xucxich.jpg','Không Cocacola 7up Cam Sting', 'Tương_ớt Tương_cà Mix'"
                + ",'Xúc xích được làm 100% từ thịt heo nhập khẩu từ Tung Của.');");

    }
}
