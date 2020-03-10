package dao.exceptions;

/**
 * 
 * @author Pascal
 * 
 */
/**
 * Une exception lev�e par un DAO et li�e � la persistance.
 */
public class DAOException extends Exception {
  /**
	 * 
	 */
	private static final long serialVersionUID = -6111973666438757776L;
/**
   * Code de l'erreur.
   * -1 s'il y a une exception cha�n�e ;
   * 1 pour connexion pas ouverte ;
   * 2 pour connexion d�j� ouverte ;
   * 4 si pas de transaction en cours ;
   * ...
   */
  private int codeErreur;

  public DAOException() {
  }

  public DAOException(String message) {
    this(message, 0);
  }

  /**
   * Cr�e une nouvelle exception avec un message et une cause donn�s.
   * @param message le message qui explique le probl�me.
   * @param cause une exception qui est la cause du probl�me. Le type de cette
   * exception doit �tre cach� � l'utilisateur du DAO et ne pas appara�tre
   * dans l'interface de la classe DaoException. Cette cause peut �tre
   * connue de l'utilisateur par l'appel de la m�thode getCause() h�rit�e
   * de Exception.
   */
  public DAOException(String message, Throwable cause) {
    super(message, cause);
    this.codeErreur = -1;
  }

  public DAOException(Throwable cause) {
    this(null, cause);
  }
  
  public DAOException(String message, int codeErreur) {
    super(message);
    this.codeErreur = codeErreur;
  }
  
  public int getCode() {
    return codeErreur;
  }
}
