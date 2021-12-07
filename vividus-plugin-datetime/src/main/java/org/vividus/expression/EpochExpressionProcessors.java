/*
 * Copyright 2019-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.vividus.expression;

import static java.lang.Long.parseLong;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.inject.Named;

import org.vividus.util.DateUtils;

@Named
public class EpochExpressionProcessors extends DelegatingExpressionProcessor<String>
{
    public EpochExpressionProcessors(DateUtils dateUtils)
    {
        super(List.of(
            new UnaryExpressionProcessor("toEpochSecond",
                arg -> String.valueOf(dateUtils.parseDateTime(arg, DateTimeFormatter.ISO_DATE_TIME).toEpochSecond())),
            new UnaryExpressionProcessor("fromEpochSecond",
                arg -> DateTimeFormatter.ISO_DATE_TIME.format(dateUtils.fromEpochSecond(parseLong(arg))))
            ));
    }
}