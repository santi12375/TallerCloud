package cloud.tallercloud.mapper;

/* Las interfaces son contratos, dicen lo que haré pero no como lo haré*/
/* Lo ideal sería comunicar siempre capas mediante interfaces es buena practica*/
public interface IMapper<input,output>{
    public output map(input in);
}
