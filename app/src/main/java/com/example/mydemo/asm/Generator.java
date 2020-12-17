package com.example.mydemo.asm;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * @author jianxiong.deng
 * @date 2020/12/12
 * @des
 */
class Generator {
    public static void main(String[] args){
        try {
            ClassReader  classReader = new ClassReader("com/example/mydemo/asm/Base");
            ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);

            ClassVisitor classVisitor = new MyClassVisitor(classWriter);
            classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
            byte[] data = classWriter.toByteArray();
            //输出
            File f = new File("/Users/klook/Desktop/Base.class");
            FileOutputStream fout = new FileOutputStream(f);
            fout.write(data);
            fout.close();
            System.out.println("now generator cc success!!!!!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
