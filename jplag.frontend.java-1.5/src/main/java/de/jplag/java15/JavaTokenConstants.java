package de.jplag.java15;

public interface JavaTokenConstants extends de.jplag.TokenConstants {
  final static int FILE_END = 0;
  
  // Used to optionally separate methods from each other
  // with an always marked token
  final static int SEPARATOR_TOKEN = 1;

  final static int J_PACKAGE = 2;               //
  final static int J_IMPORT = 3;                //
  final static int J_CLASS_BEGIN = 4;           //
  final static int J_CLASS_END = 5;             //
  final static int J_METHOD_BEGIN = 6;          //
  final static int J_METHOD_END = 7;            //
  final static int J_VARDEF = 8;                //
  final static int J_SYNC_BEGIN = 9;            //
  final static int J_SYNC_END = 10;              //
  final static int J_DO_BEGIN = 11;             //
  final static int J_DO_END = 12;               //
  final static int J_WHILE_BEGIN = 13;          //
  final static int J_WHILE_END = 14;            //
  final static int J_FOR_BEGIN = 15;            //
  final static int J_FOR_END = 16;              //
  final static int J_SWITCH_BEGIN = 17;         //
  final static int J_SWITCH_END = 18;           //
  final static int J_CASE = 19;                 //
  final static int J_TRY_BEGIN = 20;            //
  final static int J_CATCH_BEGIN = 21;          //
  final static int J_CATCH_END = 22;            //
  final static int J_FINALLY = 23;              //
  final static int J_IF_BEGIN = 24;             //
  final static int J_ELSE = 25;                 //
  final static int J_IF_END = 26;               //
  final static int J_COND = 27;                 //
  final static int J_BREAK = 28;                //
  final static int J_CONTINUE = 29;             //
  final static int J_RETURN = 30;               //
  final static int J_THROW = 31;                //
  final static int J_IN_CLASS_BEGIN=32;         //
  final static int J_IN_CLASS_END = 33;         //
  final static int J_APPLY = 34;                //
  final static int J_NEWCLASS = 35;             //
  final static int J_NEWARRAY = 36;             //
  final static int J_ASSIGN = 37;               //
  final static int J_INTERFACE_BEGIN=38;        //
  final static int J_INTERFACE_END = 39;        //
  final static int J_CONSTR_BEGIN = 40;         //
  final static int J_CONSTR_END = 41;           //
  final static int J_INIT_BEGIN = 42;           //
  final static int J_INIT_END = 43;             //
  final static int J_VOID = 44;                 //
  final static int J_ARRAY_INIT_BEGIN = 45;     //
  final static int J_ARRAY_INIT_END = 46;       //
  // new in 1.5:
  final static int J_ENUM_BEGIN = 47;           //
  final static int J_ENUM_CLASS_BEGIN = 48;     //
  final static int J_ENUM_END = 49;             //
  final static int J_GENERIC = 50;              //
  final static int J_ASSERT = 51;               //

  final static int J_ANNO = 52;                 //
  final static int J_ANNO_MARKER = 53;          //
  final static int J_ANNO_M_BEGIN = 54;         //
  final static int J_ANNO_M_END = 55;           //
  final static int J_ANNO_T_BEGIN = 56;         //
  final static int J_ANNO_T_END = 57;           //
  final static int J_ANNO_C_BEGIN = 58;         //
  final static int J_ANNO_C_END = 59;           //
  
  final static int NUM_DIFF_TOKENS = 60;
}
