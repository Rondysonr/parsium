; Código LLVM IR gerado pelo Parsium
declare i32 @printf(i8*, ...)
@.str.int = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@.str.fmt = private unnamed_addr constant [4 x i8] c"%s\0A\00"
define i32 @main() {

  ; Código de controle de fluxo
L1:                               ; bloco THEN
  add i32 0, 0                       ; no-op para evitar bloco vazio
  br label %exit

L0:                               ; bloco ELSE
  add i32 0, 0                       ; no-op para evitar bloco vazio
  br label %exit

exit:                             ; bloco de saída
  ret i32 0
  ret i32 0
}
