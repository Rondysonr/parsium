declare i32 @printf(i8*, ...)
@.str.int = private constant [4 x i8] c"%d\0A\00"
@.str.space = private constant [2 x i8] c" \00"
@.str.newline = private constant [2 x i8] c"\0A\00"

define i32 @main() {
entry:
  %t0.0 = add i32 0, 5
  %n.1 = add i32 0, %t0
  %i.2 = add i32 0, 0
  br label %L0

L0:
  %cond3 = icmp ne i32 0, 0
  br label %exit
  %j.4 = add i32 0, 0
  %val.5 = add i32 0, 1
  br label %L2

L2:
  %cond6 = icmp ne i32 0, 0
  br label %exit
  %t1.7 = sub i32 %i.2, %j.4
  %t2.8 = mul i32 %val.5, %t1
  %t3.9 = add i32 %j.4, 1
  %t4.10 = sdiv i32 %t2, %t3
  %val.11 = add i32 0, %t4
  %t5.12 = add i32 %j.4, 1
  %j.13 = add i32 0, %t5
; Erro na geração
define i32 @main() {
  ret i32 0
}
