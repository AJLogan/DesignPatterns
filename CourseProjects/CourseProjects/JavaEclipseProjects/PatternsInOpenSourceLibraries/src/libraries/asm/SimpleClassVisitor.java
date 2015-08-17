package libraries.asm;

import org.objectweb.asm.*;

public class SimpleClassVisitor implements ClassVisitor {
    public void visit(int version, int access, String name, String signature, String baseClassName, String[] interfaces) {
        System.out.printf("Class %1$s inheriting from %2$s with contents:\n",name.replace('/','.'),baseClassName.replace('/','.'));
    }
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        System.out.printf("\t--->Field %1$s of type %2$s\n",name.replace('/','.'),Type.getType(desc).toString().replace('/','.'));
        return null;
    }
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if(name.equals("<init>")) {
            System.out.println("\t--->Found a constructor");
        } else {
            System.out.printf("\t--->Method %1$s returning %2$s\n",name,Type.getReturnType(desc).toString().replace('/','.'));
        }
        return new SimpleMethodVisitor();
    }
    public void visitEnd() {
        System.out.println();
    }
     public AnnotationVisitor visitAnnotation(String string, boolean b) {
        return null;
    }
    public void visitSource(String string, String string1) {}
    public void visitOuterClass(String string, String string1, String string2) {}
    public void visitAttribute(Attribute attribute) {}
    public void visitInnerClass(String string, String string1, String string2, int i) {}

    private static class SimpleMethodVisitor implements MethodVisitor {
        public void visitMethodInsn(int opcode, String owner, String name, String desc) {
            if(name.equals("<init>")) {
                System.out.printf("\t\t--->Found the creation of an %1$s instance\n",owner.replace('/','.'));
            } else {
                System.out.printf("\t\t--->Found a call to %1$s in %2$s\n",name,owner.replace('/','.'));
            }
        }
        public AnnotationVisitor visitAnnotationDefault() {
            return null;
        }
        public AnnotationVisitor visitAnnotation(String string, boolean b) {
            return null;
        }
        public AnnotationVisitor visitParameterAnnotation(int i, String string, boolean b) {
            return null;
        }
        public void visitAttribute(Attribute attribute) {}
        public void visitCode() {}
        public void visitInsn(int i) {}
        public void visitIntInsn(int i, int i1) {}
        public void visitVarInsn(int i, int i1) {}
        public void visitTypeInsn(int i, String string) {}
        public void visitFieldInsn(int i, String string, String string1, String string2) {}
        public void visitJumpInsn(int i, Label label) {}
        public void visitLabel(Label label) {}
        public void visitLdcInsn(Object object) {}
        public void visitIincInsn(int i, int i1) {}
        public void visitTableSwitchInsn(int i, int i1, Label label, Label[] labels) {}
        public void visitLookupSwitchInsn(Label label, int[] ints, Label[] labels) {}
        public void visitMultiANewArrayInsn(String string, int i) {}
        public void visitTryCatchBlock(Label label, Label label1, Label label2, String string) {}
        public void visitLocalVariable(String string, String string1, String string2, Label label, Label label1, int i) {}
        public void visitLineNumber(int i, Label label) {}
        public void visitMaxs(int i, int i1) {}
        public void visitEnd() {}
    }
}

