# spring boot redis cache
## 注意事项
> 1.`#p0`必须是String类型，可以使用`#p0.toString()`.<br>
  2. LocalDateTime得加@JsonDeserialize(using = LocalDateTimeDeserializer.class) @JsonSerialize(using = LocalDateTimeSerializer.class)注解，
  这里和前端传入来得注解不同@JsonFormatDate,主要作用于序列化。
