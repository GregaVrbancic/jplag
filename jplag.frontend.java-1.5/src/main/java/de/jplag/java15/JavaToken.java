package de.jplag.java15;

public class JavaToken extends de.jplag.Token implements JavaTokenConstants {
	private static final long serialVersionUID = 3743208940428676175L;
	private int line, column, length;

	public JavaToken(int type, String file, int line, int column, int length) {
		super(type, file, line, column, length);
	}

	@Override
    public int getLine() { return line; }
	@Override
    public int getColumn() { return column; }
	@Override
    public int getLength() { return length; }
	@Override
    public void setLine(int line) { this.line = line; }
	@Override
    public void setColumn(int column) { this.column = column; }
	@Override
    public void setLength(int length) { this.length = length; }

  public static String type2string(int type) {
    switch (type) {
		case JavaTokenConstants.FILE_END:				// @formatter:off
                            return "********";
	case JavaTokenConstants.SEPARATOR_TOKEN:
							return "METHOD_SEPARATOR";
    case J_PACKAGE:         return "PACKAGE ";
    case J_IMPORT:          return "IMPORT  ";
    case J_CLASS_BEGIN:     return "CLASS{  ";
    case J_CLASS_END:       return "}CLASS  ";
    case J_METHOD_BEGIN:    return "METHOD{ ";
    case J_METHOD_END:      return "}METHOD ";
    case J_VARDEF:          return "VARDEF  ";
    case J_SYNC_BEGIN:      return "SYNC{   ";
    case J_SYNC_END:        return "}SYNC   ";
    case J_DO_BEGIN:        return "DO{     ";
    case J_DO_END:          return "}DO     ";
    case J_WHILE_BEGIN:     return "WHILE{  ";
    case J_WHILE_END:       return "}WHILE  ";
    case J_FOR_BEGIN:       return "FOR{    ";
    case J_FOR_END:         return "}FOR    ";
    case J_SWITCH_BEGIN:    return "SWITCH{ ";
    case J_SWITCH_END:      return "}SWITCH ";
    case J_CASE:            return "CASE    ";
    case J_TRY_BEGIN:       return "TRY{    ";
    case J_CATCH_BEGIN:     return "CATCH{  ";
    case J_CATCH_END:       return "}CATCH  ";
    case J_FINALLY:         return "FINALLY ";
    case J_IF_BEGIN:        return "IF{     ";
    case J_ELSE:            return "ELSE    ";
    case J_IF_END:          return "}IF     ";
    case J_COND:            return "COND    ";
    case J_BREAK:           return "BREAK   ";
    case J_CONTINUE:        return "CONTINUE";
    case J_RETURN:          return "RETURN  ";
    case J_THROW:           return "THROW   ";
    case J_IN_CLASS_BEGIN:  return "INCLASS{";
    case J_IN_CLASS_END:    return "}INCLASS";
    case J_APPLY:           return "APPLY   ";
    case J_NEWCLASS:        return "NEWCLASS";
    case J_NEWARRAY:        return "NEWARRAY";
    case J_ASSIGN:          return "ASSIGN  ";
    case J_INTERFACE_BEGIN: return "INTERF{ ";
    case J_INTERFACE_END:   return "}INTERF ";
    case J_CONSTR_BEGIN:    return "CONSTR{ ";
    case J_CONSTR_END:      return "}CONSTR ";
    case J_INIT_BEGIN:      return "INIT{   ";
    case J_INIT_END:        return "}INIT   ";
    case J_VOID:            return "VOID    ";
    case J_ARRAY_INIT_BEGIN:return "ARRINIT{";
    case J_ARRAY_INIT_END:  return "ARRINIT}";
    case J_ENUM_BEGIN:      return "ENUM{   ";
    case J_ENUM_CLASS_BEGIN:return "ENUM_CLA";
    case J_ENUM_END:        return "}ENUM   ";
    case J_GENERIC:         return "GENERIC ";
    case J_ASSERT:          return "ASSERT  ";
    case J_ANNO:            return "ANNO    ";
    case J_ANNO_MARKER:     return "ANNOMARK";
    case J_ANNO_M_BEGIN:    return "ANNO_M{ ";
    case J_ANNO_M_END:      return "}ANNO_M ";
    case J_ANNO_T_BEGIN:    return "ANNO_T{ ";
    case J_ANNO_T_END:      return "}ANNO_T ";
    case J_ANNO_C_BEGIN:    return "ANNO_C{ ";
    case J_ANNO_C_END:      return "}ANNO_C ";

    default:                return "*UNKNOWN"; // @formatter:on
    }
  }
  
  public static int numberOfTokens() { 
    return NUM_DIFF_TOKENS;
  }
}

