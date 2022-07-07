package com.dh.meli.desafioSpring.service;

import com.dh.meli.desafioSpring.dto.ProdutoDto;
import com.dh.meli.desafioSpring.model.Produto;
import com.dh.meli.desafioSpring.repository.ProdutoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementação dos métodos da interface ProdutoService.
 */
@Service
public class ProdutoServiceImp implements ProdutoService{

    @Autowired
    private ProdutoRepo produtoRepo;


    /**
     * Chama o método em ProdutoRepo para cadastro de produto.
     * @param produto
     */
    @Override
    public void cadastrarProduto(Produto produto) {
            produtoRepo.cadastrarProduto(produto);
    }

    /**
     * Inicia com a lista de todos os produtos cadastrados,
     * filtra produtos com atributo quantidade maior que zero,
     * converte do tipo Produto para tipo ProdutoDto,
     * retorna lista de produtos disponíveis de acordo com quantidade.
     * Em caso de exceção, mostra mensagem de erro.
     * @return listaDisponiveisDto
     */
    @Override
    public List<ProdutoDto> getAllProdutosDisponiveis() {
        List<Produto> listaDisponiveis = produtoRepo.getAll();
        List<ProdutoDto> listaDisponiveisDto = null;
        try{
            listaDisponiveisDto = listaDisponiveis.stream()
                    .filter(p -> p.getQuantity() > 0 )
                    .map(ProdutoDto::new)
                    .collect(Collectors.toList());

        } catch(Exception exception){

        }
        return listaDisponiveisDto;
    }

    /**
     * Inicia com a lista com todos os produtos cadastrados,
     * filtra por categoria (input recebido do cliente),
     * converte do tipo Produto para ProdutoDto,
     * retorna lista de produtos da categoria selecionada.
     * Em caso de exceção, mostra mensagem de erro.
     * @param categoria
     * @return listaCategoriaDto
     */
    @Override
    public List<ProdutoDto> getAllCategoria(String categoria) {
        List<Produto> listaCategoria = produtoRepo.getAll();
        List<ProdutoDto> listaCategoriaDto = null;
        try{
            listaCategoriaDto = listaCategoria.stream()
                    .filter(p -> p.getCategory().equalsIgnoreCase(categoria) )
                    .map(ProdutoDto::new)
                    .collect(Collectors.toList());

        } catch(Exception exception){

        }
        return listaCategoriaDto;
    }

    /**
     * Chama método getAll de ProdutoRepo,
     * converte do tipo Produto para ProdutoDto,
     * retorna listaDto com todos os produtos cadastrados.
     * @return listaDto
     */
    @Override
    public List<ProdutoDto> getAll(){
        List<ProdutoDto> listaDto = produtoRepo.getAll().stream().map(ProdutoDto::new).collect(Collectors.toList());
        return listaDto;
    }

    /**
     * Inicia com a lista de todos os produtos cadastrados,
     * filtra por categoria (input do usuário: string com o nome da categoria)
     * e pela opção de frete grátis (input do usuário: true ou false),
     * converte para ProdutoDto,
     * retorna lista de produtos filtrados pelos parâmetros.
     * @param category
     * @param freeShipping
     * @return listaFiltrosDto
     */
    @Override
    public List<ProdutoDto> getByCategoryAndFree(String category, boolean freeShipping) {
        List<Produto> allProducts = produtoRepo.getAll();
        List<ProdutoDto> listaFiltrosDto = null;
        try{
            listaFiltrosDto = allProducts.stream()
                    .filter(p -> p.getCategory().equalsIgnoreCase(category) && p.getFreeShipping().equals(freeShipping))
                    .map(ProdutoDto::new)
                    .collect(Collectors.toList());

        } catch(Exception exception){

        }
        return listaFiltrosDto;
    }

    /**
     * Inicia com a lista de todos os produtos cadastrados,
     * filtra por categoria (input do usuário: string com o nome da categoria)
     * e por avaliação (input do usuário: string com avaliação em forma de asterisco, ex: ***),
     * converte para ProdutoDto,
     * retorna lista de produtos filtrados pelos parâmetros.
     * @param category
     * @param prestige
     * @return listaFiltrosDto
     */
    @Override
    public List<ProdutoDto> getByCategoryAndPrestige(String category, String prestige) {
        List<Produto> allProducts = produtoRepo.getAll();
        List<ProdutoDto> listaFiltrosDto = null;
        try{
            listaFiltrosDto = allProducts.stream()
                    .filter(p -> p.getCategory().equalsIgnoreCase(category) && p.getPrestige().equals(prestige))
                    .map(ProdutoDto::new)
                    .collect(Collectors.toList());

        } catch(Exception exception){

        }
        return listaFiltrosDto;
    }


    /**
     * Inicia com a lista filtrada por categoria e frete grátis,
     * e executa o método de ordenação de maneira diferente dependendo do
     * valor do parâmetro order (0 - alfabético crescente, 1 - alfabético decrescente
     * 2 - maior preço, 3 - menor preço.)
     * @param category
     * @param freeShipping
     * @param order
     * @return listOrdered
     */
    @Override
    public List<ProdutoDto> getByCategoryFreeOrdered(String category, boolean freeShipping, int order) {
        List<ProdutoDto> listOrdered = this.getByCategoryAndFree(category, freeShipping);
        switch(order) {
            case 0:
                return listOrdered.stream().sorted((p1,p2)-> p1.getName().compareTo(p2.getName())).collect(Collectors.toList());
            case 1:
                return listOrdered.stream().sorted((p1,p2)-> p2.getName().compareTo(p1.getName())).collect(Collectors.toList());
            case 2:
                return listOrdered.stream().sorted((p1,p2)-> p1.getPrice().compareTo(p2.getPrice())).collect(Collectors.toList());
            case 3:
                return listOrdered.stream().sorted((p1,p2)-> p2.getPrice().compareTo(p1.getPrice())).collect(Collectors.toList());
            default:
                return null;
        }
    }

}

