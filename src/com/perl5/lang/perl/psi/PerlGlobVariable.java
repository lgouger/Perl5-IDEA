/*
 * Copyright 2015 Alexandr Evstigneev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.perl5.lang.perl.psi;

import com.intellij.psi.PsiElement;
import com.perl5.lang.perl.psi.properties.PerlNamedElement;
import com.perl5.lang.perl.psi.properties.PerlNamespaceElementContainer;
import com.perl5.lang.perl.psi.properties.PerlPackageMember;
import com.perl5.lang.perl.psi.properties.PerlVariableNameElementContainer;

/**
 * Created by hurricup on 25.05.2015.
 */
public interface PerlGlobVariable extends PsiElement, PerlPackageMember, PerlNamespaceElementContainer, PerlVariableNameElementContainer, PerlNamedElement
{
	/**
	 * Checks if this typeglob is left part of assignment
	 *
	 * @return result
	 */
	boolean isLeftSideOfAssignment();
}
