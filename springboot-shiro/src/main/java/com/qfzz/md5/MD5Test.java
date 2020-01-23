package com.qfzz.md5;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Test {

    public static void main(String[] args) {

        String password = "123";//明文密码

        /**
         * 通过md5加密的密码是由：盐和明文密码组合形成
         * "盐"加的越多，密码越安全
         * 因为就算破解出来，也是混合着真密码和盐的字符串
         * 不清楚盐到底有几位
         */
        //往密码中添加"佐料",添加的越多密码安全性越高
        String salt = "abc";

        /**
         * 散列次数,为1的时候不变，>1时就会再次改变密码(在上面的基础上)
         * 散列次数为1：e99a18c428cb38d5f260853678922e03
         * 散列次数为2：b106dc6352e5ec1f8aafd8c406d34d92
         * 加上散列次数后，破解出来的密码是盐和密码不规则排序的字符串
         */
        int hashIterations = 2;

        // 第一种方式   MD5加密
        /**
         * 构造方法中：
         * 第一个参数：明文，原始密码
         * 第二个参数：盐，通过使用随机数
         * 第三个参数：散列的次数，比如散列两次，相当于 md5(md5(''))
         *
         * Md5Hash md5Hash = new Md5Hash(password,salt,hashIterations);
         * String md5_pwd = md5Hash.toString();
         * System.out.println(md5_pwd);
          */
        Md5Hash md5Hash = new Md5Hash(password);
        System.out.println(md5Hash.toString());

        // 第二种方式
        // 第一个参数：散列算法
        //加密后的密码和上面第一种方式一样：b106dc6352e5ec1f8aafd8c406d34d92
        SimpleHash simpleHash = new SimpleHash("md5",password,salt,hashIterations);

        System.out.println(simpleHash.toString());

    }
}
