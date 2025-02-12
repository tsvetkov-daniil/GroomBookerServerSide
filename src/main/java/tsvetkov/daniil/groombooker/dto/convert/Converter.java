package tsvetkov.daniil.groombooker.dto.convert;

public interface Converter<E,T>{
    E dtoToEntity(T dto);
    T enitytToDto(E entity);
}
