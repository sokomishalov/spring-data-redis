/*
 * Copyright 2011-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.redis.core;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.connection.RedisListCommands.Direction;

/**
 * Default implementation for {@link BoundListOperations}.
 *
 * @author Costin Leau
 * @author Mark Paluch
 */
class DefaultBoundListOperations<K, V> extends DefaultBoundKeyOperations<K> implements BoundListOperations<K, V> {

	private final ListOperations<K, V> ops;

	/**
	 * Constructs a new <code>DefaultBoundListOperations</code> instance.
	 *
	 * @param key
	 * @param operations
	 */
	DefaultBoundListOperations(K key, RedisOperations<K, V> operations) {

		super(key, operations);
		this.ops = operations.opsForList();
	}

	@Override
	public RedisOperations<K, V> getOperations() {
		return ops.getOperations();
	}

	@Override
	public V index(long index) {
		return ops.index(getKey(), index);
	}

	@Override
	public Long indexOf(V value) {
		return ops.indexOf(getKey(), value);
	}

	@Override
	public Long lastIndexOf(V value) {
		return ops.lastIndexOf(getKey(), value);
	}

	@Override
	public V leftPop() {
		return ops.leftPop(getKey());
	}

	@Override
	public List<V> leftPop(long count) {
		return ops.leftPop(getKey(), count);
	}

	@Override
	public V leftPop(long timeout, TimeUnit unit) {
		return ops.leftPop(getKey(), timeout, unit);
	}

	@Override
	public Long leftPush(V value) {
		return ops.leftPush(getKey(), value);
	}

	@Override
	public Long leftPushAll(V... values) {
		return ops.leftPushAll(getKey(), values);
	}

	@Override
	public Long leftPushIfPresent(V value) {
		return ops.leftPushIfPresent(getKey(), value);
	}

	@Override
	public Long leftPush(V pivot, V value) {
		return ops.leftPush(getKey(), pivot, value);
	}

	@Override
	public Long size() {
		return ops.size(getKey());
	}

	@Override
	public List<V> range(long start, long end) {
		return ops.range(getKey(), start, end);
	}

	@Override
	public Long remove(long i, Object value) {
		return ops.remove(getKey(), i, value);
	}

	@Override
	public V rightPop() {
		return ops.rightPop(getKey());
	}

	@Override
	public List<V> rightPop(long count) {
		return ops.rightPop(getKey(), count);
	}

	@Override
	public V rightPop(long timeout, TimeUnit unit) {
		return ops.rightPop(getKey(), timeout, unit);
	}

	@Override
	public Long rightPushIfPresent(V value) {
		return ops.rightPushIfPresent(getKey(), value);
	}

	@Override
	public Long rightPush(V value) {
		return ops.rightPush(getKey(), value);
	}

	@Override
	public Long rightPushAll(V... values) {
		return ops.rightPushAll(getKey(), values);
	}

	@Override
	public Long rightPush(V pivot, V value) {
		return ops.rightPush(getKey(), pivot, value);
	}

	@Override
	public V move(Direction from, K destinationKey, Direction to) {
		return ops.move(getKey(), from, destinationKey, to);
	}

	@Override
	public V move(Direction from, K destinationKey, Direction to, Duration timeout) {
		return ops.move(getKey(), from, destinationKey, to, timeout);
	}

	@Override
	public V move(Direction from, K destinationKey, Direction to, long timeout, TimeUnit unit) {
		return ops.move(getKey(), from, destinationKey, to, timeout, unit);
	}

	@Override
	public void trim(long start, long end) {
		ops.trim(getKey(), start, end);
	}

	@Override
	public void set(long index, V value) {
		ops.set(getKey(), index, value);
	}

	@Override
	public DataType getType() {
		return DataType.LIST;
	}
}
