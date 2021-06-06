package ru.tatarchuk.personaldictionary.presentation.core

/**
 * @author tatarchukilya@gmail.com
 */
class CustomNavigationStack<T>(val state: MutableList<T>) {

    fun current() = state.last()

    fun pop(): T? {
        if (state.size > 1) {
            state.removeLast()
            return state.last()
        }
        return null
    }

    fun put(id: T): T {
        val position = state.indexOf(id)
        if (position == -1) { // Такого типа нет, просо добавляем
            state.add(id)
        }
        if (position == 0) { // Home Tab, чистим все, что выше
            while (state.size > 1) {
                state.removeLast()
            }
        } else if (position > 0) { // Если такой тип уже добавлен, тащит его на вершину
            state.removeAt(position)
            state.add(id)
        }
        return state.last()
    }
}