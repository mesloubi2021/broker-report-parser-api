/*
 * Broker Report Parser API
 * Copyright (C) 2021  Vitalii Ananev <an-vitek@ya.ru>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.spacious_team.broker.report_parser.api;

import lombok.Getter;

public abstract class AbstractReportTables<T extends BrokerReport> implements ReportTables {

    @Getter
    protected final T report;
    private final EmptyReportTable<?> emptyReportTable;

    protected AbstractReportTables(T report) {
        this.report = report;
        this.emptyReportTable = EmptyReportTable.of(report);
    }

    @SuppressWarnings("unchecked")
    protected <E> EmptyReportTable<E> emptyTable() {
        return (EmptyReportTable<E>) emptyReportTable;
    }
}
