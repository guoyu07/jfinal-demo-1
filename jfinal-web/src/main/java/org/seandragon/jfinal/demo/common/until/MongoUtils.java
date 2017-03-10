//package org.seandragon.jfinal.demo.common.until;
//
//
//import org.apache.log4j.Logger;
//import org.bson.types.ObjectId;
//import pro.mojo.mongo.dao.IMongoAdapter;
//import pro.mojo.mongo.dao.MongoAdapter;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.Type;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**
// * Created by SeanDragon on 2016/12/15.
// */
//public class MongoUtils {
//
//    private static Logger logger = Logger.getLogger(MongoUtils.class);
//
//    public static <T> T cloneModel(T t) {
//        String object_str = pro.cg.convert.ModelToBson(t);
//        System.err.println(object_str);
//        return (T) pro.cg.convert.BsonToModel(object_str, t.getClass());
//    }
//
//
//    public static class factory {
//        public static IMongoAdapter createTuhaoP2p() {
//            try {
//                return new MongoAdapter("tuhao-p2p");
//            } catch (Exception e) {
//                Logger.getRootLogger().error(e.getMessage());
//                return null;
//            }
//        }
//
//        public static IMongoAdapter createTuhaoLog() {
//            try {
//                return new MongoAdapter("tuhao-log");
//            } catch (Exception e) {
//                Logger.getRootLogger().error(e.getMessage());
//                return null;
//            }
//        }
//    }
//
//    public static Type getTypeWithField(Object object, String fieldName) {
//        Type type = null;
//        try {
//            type = object.getClass().getDeclaredField(fieldName).getGenericType();
//        } catch (NoSuchFieldException e) {
//            Logger.getRootLogger().error(pro.cg.tools.toException(e));
//        }
//        return type;
//    }
//
//    public static Object getValueWithField(Object object, String fieldName) {
//        Object value = null;
//        try {
//            Field e = object.getClass().getDeclaredField(fieldName);
//            e.setAccessible(true);
//            value = e.get(object);
//            e.setAccessible(false);
//        } catch (NoSuchFieldException | IllegalAccessException var4) {
//            Logger.getRootLogger().error(var4.getMessage());
//        }
//
//        return value;
//    }
//
//    public static boolean setFieldValue(Object object, String fieldName, Object value) {
//        boolean v = false;
//
//        try {
//            Field e = object.getClass().getDeclaredField(fieldName);
//            e.setAccessible(true);
//            e.set(object, value);
//            e.setAccessible(false);
//            v = true;
//        } catch (NoSuchFieldException | IllegalAccessException var5) {
//            Logger.getRootLogger().error(var5.getMessage());
//        }
//
//        return v;
//    }
//
//    public static Object init(Object obj) {
//        Field[] fields = obj.getClass().getDeclaredFields();
//        int length = fields.length;
//
//        for (int count = 0; count < length; ++count) {
//            Field f = fields[count];
//            f.setAccessible(true);
//            String t = f.getGenericType().getTypeName();
//
//            try {
//                byte fType = -1;
//                switch (t.hashCode()) {
//                    case -2056817302:
//                        if (t.equals("java.lang.Integer")) {
//                            fType = 0;
//                        }
//                        break;
//                    case -1405464277:
//                        if (t.equals("java.math.BigDecimal")) {
//                            fType = 7;
//                        }
//                        break;
//                    case -527879800:
//                        if (t.equals("java.lang.Float")) {
//                            fType = 2;
//                        }
//                        break;
//                    case 65575278:
//                        if (t.equals("java.util.Date")) {
//                            fType = 6;
//                        }
//                        break;
//                    case 344809556:
//                        if (t.equals("java.lang.Boolean")) {
//                            fType = 4;
//                        }
//                        break;
//                    case 398795216:
//                        if (t.equals("java.lang.Long")) {
//                            fType = 1;
//                        }
//                        break;
//                    case 761287205:
//                        if (t.equals("java.lang.Double")) {
//                            fType = 3;
//                        }
//                        break;
//                    case 1195259493:
//                        if (t.equals("java.lang.String")) {
//                            fType = 5;
//                        }
//                        break;
//                    case 1931139171:
//                        if (t.equals("org.bson.types.ObjectId")) {
//                            fType = 8;
//                        }
//                }
//
//                switch (fType) {
//                    case 0:
//                        f.set(obj, Integer.valueOf(0));
//                        break;
//                    case 1:
//                        f.set(obj, Integer.valueOf(0));
//                        break;
//                    case 2:
//                        f.set(obj, Integer.valueOf(0));
//                        break;
//                    case 3:
//                        f.set(obj, Integer.valueOf(0));
//                        break;
//                    case 4:
//                        f.set(obj, Boolean.valueOf(false));
//                        break;
//                    case 5:
//                        f.set(obj, "");
//                        break;
//                    case 6:
//                        f.set(obj, new Date());
//                        break;
//                    case 7:
//                        f.set(obj, new BigDecimal(0));
//                        break;
//                    case 8:
//                        f.set(obj, new ObjectId());
//                        break;
//                    default:
//                        if (f.getType().getSimpleName().equals(List.class.getSimpleName())) {
//                            Object var13 = (List) f.get(obj);
//                            if (var13 == null) {
//                                var13 = new ArrayList();
//                            }
//
//                            for (int i = 0; i < ((List) var13).size(); ++i) {
//                                init(((List) var13).get(i));
//                            }
//
//                            f.set(obj, var13);
//                        } else if (f.getType().getSuperclass() != null) {
//                            //String superName = f.getType().getSuperclass().getSimpleName();
//                            //if(superName.equals(BaseModel.class.getSimpleName())) {
//                            f.set(obj, Class.forName(f.getGenericType().getTypeName()).newInstance());
//                            init(f.get(obj));
//                            //}
//                        }
//                }
//            } catch (IllegalAccessException | ClassNotFoundException | InstantiationException var10) {
//                var10.printStackTrace();
//                logger.error(pro.cg.tools.toException(var10));
//            }
//
//            f.setAccessible(false);
//        }
//        return obj;
//    }
//}
