/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author 6fantasticos
 */
public interface IDAO<T> {
    List<T> getAll();
    T getById(int id);
    T createOrUpdate(T entity);
    T deleteById(int id);
}
