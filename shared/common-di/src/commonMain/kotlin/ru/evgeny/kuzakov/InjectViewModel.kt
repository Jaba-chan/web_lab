package ru.evgeny.kuzakov

import org.koin.core.context.GlobalContext

inline fun <reified T : Any> injectViewModel(): T{
	return GlobalContext.get().get(T::class)
}