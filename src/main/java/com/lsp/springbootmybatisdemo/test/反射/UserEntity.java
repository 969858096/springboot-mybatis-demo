package com.lsp.springbootmybatisdemo.test.反射;

/**
 * @FileName: UserEntity
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/9 21:05
 */
public class UserEntity {
    private String name = "反射对象";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class<?> aClass = Class.forName("com.lsp.springbootmybatisdemo.test.反射.UserEntity");
        Object o = aClass.newInstance();

        if (o instanceof UserEntity){
            UserEntity userEntity = (UserEntity) o;
            String name = userEntity.getName();
            System.out.println(name);
        }
    }
}
