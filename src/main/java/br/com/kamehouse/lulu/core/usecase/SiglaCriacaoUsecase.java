package br.com.kamehouse.lulu.core.usecase;

import br.com.kamehouse.lulu.core.adapter.impl.SiglaAdapterImpl;
import br.com.kamehouse.lulu.core.domain.Sigla;
import br.com.kamehouse.lulu.entrypoint.dto.ResponseDto;
import br.com.kamehouse.lulu.entrypoint.dto.SiglaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class SiglaCriacaoUsecase {

    private final SiglaAdapterImpl siglaAdapter;

    public ResponseDto<SiglaDto> criacaoDeSigla(SiglaDto siglaDto){
        this.isSiglaValidada(siglaDto);
        siglaDto.setTimestamp(LocalDateTime.now());
        Sigla sigla = new Sigla();
        BeanUtils.copyProperties(siglaDto, sigla);
        Sigla siglaSalva = this.siglaAdapter.salvar(sigla);
        BeanUtils.copyProperties(siglaSalva, siglaDto);
        return ResponseDto.of(HttpStatus.CREATED, siglaDto);
    }

    private Boolean isSiglaValidada(SiglaDto siglaDto){
        Method[] methods = siglaDto.getClass().getDeclaredMethods();
        final Boolean[] resultados = new Boolean[6];
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Arrays.stream(methods).forEach(method -> {
            method.setAccessible(true);
            if(method.getName().startsWith("get")){
                try{
                    resultados[atomicInteger.get()] = Objects.isNull(method.invoke(siglaDto));
                    atomicInteger.set(atomicInteger.get() + 1);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        });
        return Arrays.asList(resultados).stream().filter(item -> item == true).findFirst().orElse(false);
    }

}
