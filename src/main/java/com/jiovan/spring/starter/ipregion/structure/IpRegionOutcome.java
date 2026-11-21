/*
 * Copyright (c) 2020 Jiovan Ltd. All rights reserved.
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

package com.jiovan.spring.starter.ipregion.structure;


import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import com.jiovan.plexus.common.toolkit.constant.CharVariantConst;
import com.jiovan.spring.starter.ipregion.enumeration.IpRegionSegmentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * Structure for outcome of ip2region
 *
 * @author David Hsing
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@SuppressWarnings("unused")
public class IpRegionOutcome {
    private String country;
    private String area;
    private String province;
    private String city;
    private String isp;

    /**
     * Returns a new {@link IpRegionOutcome} parsed from the given composite region string
     *
     * @param composite the composite region string whose segments are separated by the vertical delimiter
     *
     * @return a new {@link IpRegionOutcome} populated from the composite string
     */
    @Nonnull
    public static IpRegionOutcome of(@Nullable String composite) {
        return new IpRegionOutcome(composite);
    }

    public IpRegionOutcome(@Nullable String composite) {
        if (StringUtils.isBlank(composite)) {
            return;
        }
        String[] outcomes = StringUtils.split(StringUtils.trimToNull(composite), CharVariantConst.VERTICAL);
        if (ArrayUtils.isEmpty(outcomes)) {
            return;
        }
        country = ArrayUtils.get(outcomes, IpRegionSegmentType.COUNTRY.getValue());
        area = ArrayUtils.get(outcomes, IpRegionSegmentType.AREA.getValue());
        province = ArrayUtils.get(outcomes, IpRegionSegmentType.PROVINCE.getValue());
        city = ArrayUtils.get(outcomes, IpRegionSegmentType.CITY.getValue());
        isp = ArrayUtils.get(outcomes, IpRegionSegmentType.ISP.getValue());
    }

    /**
     * Returns the composite address of this outcome using the default slash delimiter
     *
     * @return the composite address, or {@code null} if no valid address field is present
     */
    public String getCompositeAddress() {
        return getCompositeAddress(CharVariantConst.SLASH);
    }

    /**
     * Returns the composite address of this outcome using the given character delimiter
     *
     * @param delimiter the character used to separate the address fields
     *
     * @return the composite address, or {@code null} if no valid address field is present
     */
    public String getCompositeAddress(char delimiter) {
        return getCompositeAddress(CharUtils.toString(delimiter));
    }

    /**
     * Returns the composite address of this outcome joined from the valid country, province and city fields
     *
     * @param delimiter the string inserted between adjacent address fields, may be {@code null} to concatenate without a separator
     *
     * @return the composite address, or {@code null} if no valid address field is present
     */
    public String getCompositeAddress(@Nullable String delimiter) {
        StringBuilder builder = new StringBuilder();
        if (isValidField(country)) {
            builder.append(country);
        }
        if (isValidField(province)) {
            if (!builder.isEmpty()) {
                builder.append(StringUtils.defaultString(delimiter));
            }
            builder.append(province);
        }
        if (isValidField(city)) {
            if (!builder.isEmpty()) {
                builder.append(StringUtils.defaultString(delimiter));
            }
            builder.append(city);
        }
        return (!builder.isEmpty()) ? builder.toString() : null;
    }

    private boolean isValidField(@Nullable String field) {
        return StringUtils.isNotBlank(field) && !StringUtils.equals(field, "0");    // $NON-NLS-1$
    }
}
