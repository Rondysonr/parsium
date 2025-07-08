declare i32 @printf(i8*, ...)
@.str.int = private constant [4 x i8] c"%d\0A\00"
@.str.space = private constant [2 x i8] c" \00"
@.str.newline = private constant [2 x i8] c"\0A\00"

define i32 @main() {
entry:
  %x.0 = add i32 0, 5
  br label %exit

exit:
  ret i32 0
}
