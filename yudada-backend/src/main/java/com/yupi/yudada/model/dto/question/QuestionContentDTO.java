package com.yupi.yudada.model.dto.question;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;
//把复杂的嵌套 JSON 结构映射成了 Java 对象，并通过 Lombok 省去了所有繁琐的样板代码。

@Data                  // 自动生成 getter、setter、toString、equals、hashCode 方法
@NoArgsConstructor     // 自动生成无参构造方法（JSON 解析时必须要用到它）
@AllArgsConstructor    // 自动生成全参构造方法（方便你在代码里手动 new 它并塞值）
//QuestionContentDTO一整个题目，Option一个选项
public class QuestionContentDTO {

    /**
     * 题目标题
     */
    private String title;

    /**
     * 题目选项列表
     */
    private List<Option> options;

    /**
     * 题目选项
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
        
//为什么加加了 static：静态内部类不需要依附于外部的实例就能独立存在。在 JSON 反序列化（比如用 Jackson/Fastjson 解析）时，框架需要直接去 new 这个 Option 对象，加 static 才能保证解析成功
   public static class Option {
    private String result;  // 测评结果属性（如 "I", "E"）
    private int score;      // 得分（如 1, 0）
    private String value;   // 选项内容（如 "A选项"）
    private String key;     // 选项标识（如 "A", "B"）
}
}
/**
*这个类和 JSON 是怎么对应上的？
*{
*"title": "你是内向还是外向？",
*"options": [
* { "result": "I", "score": 1, "value": "喜欢独处", "key": "A" }
 * ]
*}
*框架看到 title，自动调用 QuestionContentDTO.setTitle("你是内向还是外向？")。

*框架看到 options 是个数组，就自动去创建 Option 对象，并把 result、score、value、key 分别塞进对应的属性里。

*/


