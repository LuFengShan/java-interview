# java字符串

## 1. java 字符串的反转


1. 使用for循环
2. 使用递归
3. 使用StringBuffer：推荐使用

示例

```java
/**
 * 反转字符串
 * 1. 使用for循环
 * 2. 使用递归
 * 3. 使用StringBuffer：推荐使用
 */
public class ReverseStringForMain {
    public static void main(String[] args) {
        ReverseStringForMain rsf = new ReverseStringForMain();
        String reverse = rsf.forReverseString("tilesile");
        System.out.println("使用for循环反转 tilesile 的结果:" + reverse);
        reverse = rsf.recursiveReverse("qwertyuiop");
        System.out.println("使用递归反转 qwertyuiop 的结果:" + reverse);
        reverse = rsf.stringBufferReverseString("asdfghjkl");
        System.out.println("使用StringBuffer反转 asdfghjkl 的结果:" + reverse);
    }

    /**
     * 使用for循环
     * @param str
     * @return
     */
    public String forReverseString(String str){
        // 使用for循环
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }
        return reverse;
    }

    /**
     * 使用递归来反转字符串
     *
     * @param orig
     * @return
     */
    public String recursiveReverse(String orig) {
        if (orig.length() == 1)
            return orig;
        else
            return orig.charAt(orig.length() - 1) + recursiveReverse(orig.substring(0, orig.length() - 1));
    }

    /**
     * 使用StringBuffer来反转字符串
     * @param str
     * @return
     */
    public String stringBufferReverseString(String str) {
        StringBuffer sb = new StringBuffer(str);
        return  sb.reverse().toString();
    }

}
```

## 2. 查找字符串中所有的子字符串

```java
/**
 * 将使用String类的subString方法来查找所有subString，基于两个for循环
 */
class SubstringsOfStringMain {
    public static void main(String args[]) {
        String str = "sun";
        System.out.println("sun的所有子字符串 : ");
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                System.out.println(str.substring(i, j));

            }
        }
    }
}
```



## 3. 在不使用java内置长度方法的情况下查找String的长度

有很多方法 :

- 使用toCharArray
- 使用StringIndexOutOfBoundsException

**使用toCharArray是最简单的解决方案**。

```java
public static int getLengthOfStringWithCharArray(String str){
  int length=0;
  char[] strCharArray=str.toCharArray();
  for(char c:strCharArray)
  {
   length++;
  }
  return length;
}
```

**使用StringIndexOutOfBoundsException：**

您一定想知道我们如何使用StringIndexOutOfBoundsException来查找String的长度。请参考以下逻辑：

**逻辑：**

- 使用0初始化i并迭代字符串而不指定任何条件。所以它永远是真的。
- 一旦i的值超过String的长度，它将抛出StringIndexOutOfBoundsException异常。
- 我们将捕获异常并在退出catch块后返回i。

```java
    public static int getLengthOfString(String str) {
        int i = 0;
        try {
            for (i = 0; ; i++) {
                str.charAt(i);
            }

        } catch (Exception e) {

        }
        return i;
    }
```

## 4. 在String中查找第一个非重复字符

### 第一种方法：

我们将使用LinkedHashMap在String中查找第一个非重复字符。

- 在循环字符串时获取字符
- 将此字符放入LinkedHashMap中并使用count。如果字符已经存在，请将计数增加1。
- 迭代时从LinkedHashMap获取计数。如果count为1，则返回该字符作为LinkedHashMap维护插入顺序。

```java
/**
 * 在String中查找第一个非重复字符
 */
public static Character getNonRepeatedCharacter(String str) {
    Map<Character, Integer> countCharacters = new LinkedHashMap<>();
    for (int i = 0; i < str.length() - 1; i++) {
        Character c = str.charAt(i);
        if (!countCharacters.containsKey(c)) {
            countCharacters.put(c, 1);
        } else {
            countCharacters.put(c, countCharacters.get(c) + 1);
        }
    }
    // 由于LinkedHashMap维护插入顺序，因此计数为1的第一个字符应返回第一个非重复字符
    for (Map.Entry<Character, Integer> e : countCharacters.entrySet()) {
        if (e.getValue() == 1)
            return e.getKey();

    }
    return null;
}
```

### 第二种方法：

**算法：**

- 遍历字符串的每个字符。
- 如果lastIndexOf和indexOf返回相同的值，则它是String中的第一个非重复字符。

```java
    public static Character getNonRepeatedCharacterCharArray(String str) {
        char charaaray[] = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (str.lastIndexOf(charaaray[i]) == str.indexOf(charaaray[i]))
                return charaaray[i];
        }
        return null;
    }
```

