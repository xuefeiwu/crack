package cn.com.cracker;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * CharlesCracker
 *
 * @author: yy
 * @Date: 2018/12/3
 * @Description:
 */
public class CharlesCracker {
    public static void main(String[] args) throws Exception {
        String outPath = "E:\\Decompiler\\charles";
        String newJar = "E:\\charles.jar";

        ClassPool pool=ClassPool.getDefault();
        pool.insertClassPath("E:\\Decompiler\\charles.jar");

        CtClass ctClass = pool.get("com.xk72.charles.kKPk");
        CtMethod ctMethod =ctClass.getDeclaredMethod("lcJx",null);
        ctMethod.setBody("{return true;}");
        ctMethod = ctClass.getDeclaredMethod("JZlU",null);
        ctMethod.setBody("{return \"Creak by yangyi\";}");
        ctClass.writeFile(outPath);

        //压缩
        Compressor zc = new Compressor(newJar);
        zc.compress(outPath);

    }
}
