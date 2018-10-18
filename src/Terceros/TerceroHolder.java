package Terceros;


public final class TerceroHolder implements org.omg.CORBA.portable.Streamable
{
  public Terceros.Tercero value = null;

  public TerceroHolder ()
  {
  }

  public TerceroHolder (Terceros.Tercero initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Terceros.TerceroHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Terceros.TerceroHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Terceros.TerceroHelper.type ();
  }

}
