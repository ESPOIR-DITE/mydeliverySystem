package repository;

public interface Irepository<T,ID>
{
   public T create(T t);
   public T update(T t);
   public void delete(ID id);
   public T read(ID id);
}//end repository
