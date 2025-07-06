; Código LLVM IR gerado pelo Parsium
declare i32 @printf(i8*, ...)
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00"
define i32 @main() {
  %$x = add i32 0, %10
  ; instrução desconhecida: IF_FALSE L0, 10
  br label %L1
  L0:
  L1:
  ret i32 0
}
