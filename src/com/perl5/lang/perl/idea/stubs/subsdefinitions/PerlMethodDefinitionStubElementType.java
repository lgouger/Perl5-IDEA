/*
 * Copyright 2016 Alexandr Evstigneev
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

package com.perl5.lang.perl.idea.stubs.subsdefinitions;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;
import com.perl5.lang.perl.psi.PerlMethodDefinition;
import com.perl5.lang.perl.psi.PerlSubDefinitionBase;
import com.perl5.lang.perl.psi.impl.PsiPerlMethodDefinitionImpl;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by hurricup on 10.11.2015.
 */
public class PerlMethodDefinitionStubElementType extends PerlSubDefinitionStubElementType
{
	public PerlMethodDefinitionStubElementType(String name)
	{
		super(name);
	}

	public PerlMethodDefinitionStubElementType(@NotNull @NonNls String debugName, @Nullable Language language)
	{
		super(debugName, language);
	}

	@Override
	public PerlSubDefinitionBase<PerlSubDefinitionStub> createPsi(@NotNull PerlSubDefinitionStub stub)
	{
		return new PsiPerlMethodDefinitionImpl(stub, this);
	}

	@NotNull
	@Override
	public PsiElement getPsiElement(@NotNull ASTNode node)
	{
		return new PsiPerlMethodDefinitionImpl(node);
	}

	@Override
	public boolean shouldCreateStub(ASTNode node)
	{
		PsiElement element = node.getPsi();
		return element instanceof PerlMethodDefinition
				&& element.isValid()
				&& StringUtil.isNotEmpty(((PerlMethodDefinition) element).getSubName());
	}
}
